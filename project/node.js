//https://auth0.com/blog/create-a-simple-and-stylish-node-express-app/
//https://mozilla.github.io/nunjucks/api.html
/**
 * Required External Modules
 */

 const express = require("express");
 const path = require("path");
 const nunjucks = require("nunjucks");
/**
 * App Variables
 */

 const app = express();
 const port = process.env.PORT || "8888";

 //var express = require('express'); // Express web server framework
 var request = require('request'); // "Request" library
 var cors = require('cors');
 var querystring = require('querystring');
 var cookieParser = require('cookie-parser');

 var client_id = '6048c6185d4941dbba9e5e61f4e57c44'; // Your client id
 var client_secret = '9095881a9eae48179b801202372a135c'; // Your secret
 var redirect_uri = 'http://localhost:8888/callback'; // Your redirect uri

 /**
  * Generates a random string containing numbers and letters
  * @param  {number} length The length of the string
  * @return {string} The generated string
  */
 var generateRandomString = function(length) {
   var text = '';
   var possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';

   for (var i = 0; i < length; i++) {
     text += possible.charAt(Math.floor(Math.random() * possible.length));
   }
   return text;
 };


/**
 *  App Configuration
 */

 nunjucks.configure('views', {
     autoescape: true,
     express: app
 });
 var stateKey = 'spotify_auth_state';
//app.set("view engine", "nunjucks")
app.use(express.static(__dirname + '/public'))
.use(cors())
.use(cookieParser());


/**
 * Routes Definitions
 */

 app.get("/", (req, res) => {
   res.render("index.html")
 });
 // app.get("/login", (req, res) => {
 //   res.render("login.html")
 // });
 app.get('/login', function(req, res) {

   var state = generateRandomString(16);
   res.cookie(stateKey, state);

   // your application requests authorization
   var scope = 'user-read-private user-read-email';
   res.redirect('https://accounts.spotify.com/authorize?' +
     querystring.stringify({
       response_type: 'code',
       client_id: client_id,
       scope: scope,
       redirect_uri: redirect_uri,
       state: state
     }));
 });
 app.get('/callback', function(req, res) {

   // your application requests refresh and access tokens
   // after checking the state parameter

   var code = req.query.code || null;
   var state = req.query.state || null;
   var storedState = req.cookies ? req.cookies[stateKey] : null;

   if (state === null || state !== storedState) {
     res.redirect('/#' +
       querystring.stringify({
         error: 'state_mismatch'
       }));
   } else {
     res.clearCookie(stateKey);
     var authOptions = {
       url: 'https://accounts.spotify.com/api/token',
       form: {
         code: code,
         redirect_uri: redirect_uri,
         grant_type: 'authorization_code'
       },
       headers: {
         'Authorization': 'Basic ' + (new Buffer(client_id + ':' + client_secret).toString('base64'))
       },
       json: true
     };

     request.post(authOptions, function(error, response, body) {
       if (!error && response.statusCode === 200) {

         var access_token = body.access_token,
             refresh_token = body.refresh_token;

         var options = {
           url: 'https://api.spotify.com/v1/me',
           headers: { 'Authorization': 'Bearer ' + access_token },
           json: true
         };

         // use the access token to access the Spotify Web API
         request.get(options, function(error, response, body) {
           console.log(body);
         });

         // we can also pass the token to the browser to make requests from there
         res.redirect('/#' +
           querystring.stringify({
             access_token: access_token,
             refresh_token: refresh_token
           }));
       } else {
         res.redirect('/#' +
           querystring.stringify({
             error: 'invalid_token'
           }));
       }
     });
   }
   console.log("access token:" + res.access_token)
 });
 app.get("/register", (req, res) => {
   res.render("register.html")
 });
 app.get("/create", (req, res) => {
   res.render("create.html")
 });
 app.get("/saved", (req, res) => {
   res.render("saved.html")
 });
 app.get("/about", (req, res) => {
   res.render("about.html")
 });
 app.get("/test", (req,res) => {
   console.log(res)
   var authOptions = {
     url: 'https://accounts.spotify.com/api/token',
     headers: { 'Authorization': 'Basic ' + (new Buffer(client_id + ':' + client_secret).toString('base64')) },
     form: {
       grant_type: 'refresh_token',
       refresh_token: refresh_token
     },
     json: true
   };
   res.redirect("/")
 });
 app.get('/refresh_token', function(req, res) {

   // requesting access token from refresh token
   var refresh_token = req.query.refresh_token;
   var authOptions = {
     url: 'https://accounts.spotify.com/api/token',
     headers: { 'Authorization': 'Basic ' + (new Buffer(client_id + ':' + client_secret).toString('base64')) },
     form: {
       grant_type: 'refresh_token',
       refresh_token: refresh_token
     },
     json: true
   };

   request.post(authOptions, function(error, response, body) {
     if (!error && response.statusCode === 200) {
       var access_token = body.access_token;
       res.send({
         'access_token': access_token
       });
     }
   });
 });
/**
 * Server Activation
 */
 app.listen(port, () => {
   console.log(`Listening to requests on http://localhost:${port}`);
 });
