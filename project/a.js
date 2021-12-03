var express = require('express');
const redis = require('redis');

var nunjucks = require("nunjucks");
var bodyparser = require("body-parser");
var request = require('request'); // "Request" library
var cors = require('cors');
var querystring = require('querystring');
var cookieParser = require('cookie-parser');
var session = require('express-session');
var sqlite3 = require('sqlite3').verbose();

//var express = require('express');
//var session = require('express-session');
var router = express.Router();
var qs = require("querystring");
let db = new sqlite3.Database('comments.db');

let RedisStore = require('connect-redis')(session);
var client  = redis.createClient();
//client.on('error', console.error)
//client.connect();
const app = express();

nunjucks.configure('views', {
    autoescape: true,
    express: app
});
app.use(express.static(__dirname + '/public'))
.use(cors())
.use(bodyparser.urlencoded({extended:true}))
.use(session({
    secret: 'TEMPlol91823810',
    // create new redis store.
    //store: new RedisStore({client:client}),
    saveUninitialized: false,
    resave: false,
}))
.use(cookieParser())
.use(function(req,res,next) { // use this middleware to set variables that all templates have : )
  if (typeof req.session == undefined || req.session == null) {
    req.session.name = 'Not logged in';
  }
  res.locals.name = req.session.name;
  res.locals.n = req.session.n;
  console.log(res.locals);
  console.log(req.session);
  next();
});

app.set("view engine", "nunjucks")

var SpotifyWebApi = require('spotify-web-api-node');

// variables set up for new auth type
var scopes = ['user-read-private', 'user-read-email','playlist-modify-public','playlist-modify-private'],
redirectUri= 'http://134.250.79.116:8888/callback',
clientId= "6048c6185d4941dbba9e5e61f4e57c44",
state = "",
showDialog= true,
responseType= "code";
// https://github.com/thelinmichael/spotify-web-api-node
require('dotenv').config();

var spotifyApi = new SpotifyWebApi({
  redirectUri:redirectUri,
  clientSecret: '9095881a9eae48179b801202372a135c',
  clientId:clientId
});
function setname(req, res) {
  if (typeof req.session !== undefined || req.session != null)  {
    res.locals.name = req.session.name; //reset this for if it's called after the middleware? // I don't think this is good practice, I need some artitecture for this spagehtti mess lol
    //req.session.n= 1;
  }else {
    req.session.name = "Not Logged In"
    res.session.n = undefined;
  }
}
function checklogin(req, res) {
  if (req.session.access && req.session.refresh)  {
    //console.log("login set, continue");
    spotifyApi.setAccessToken(req.session.access);
    spotifyApi.setRefreshToken(req.session.refresh);
    return true;
  } else {
    //console.log("not logged in");
    return false;
  }
}

router.get('/', function(req, res, next) {
  //sess = req.session;
  res.render('index.html', { title: 'Home' });
});

router.get('/login', (req,res) => {
  res.redirect(spotifyApi.createAuthorizeURL(scopes));
});

router.get('/callback', async (req,res) => {
  //console.log(JSON.stringify(result.tracks.items, null, 2));
    //ses = req.session;
    var error = req.query.error;
    var code = req.query.code;
    var state = req.query.state;
    res.cookie("code",code);
    if (error) {
   console.error('Callback Error:', error);
   //res.send(`Callback Error: ${error}`);
   //return;
 }
 await spotifyApi
    .authorizationCodeGrant(code)
    .then(data => {
      const access_token = data.body['access_token'];
      const refresh_token = data.body['refresh_token'];
      const expires_in = data.body['expires_in'];

      req.session.access = access_token;
      req.session.refresh = refresh_token;
      // console.log(req.session.access);
      // console.log("set the token to the above");


      spotifyApi.setAccessToken(access_token);
      spotifyApi.setRefreshToken(refresh_token);

      console.log('access_token:', access_token);
      console.log('refresh_token:', refresh_token);
      //
      // console.log(
      //   `Sucessfully retreived access token. Expires in ${expires_in} s.`
      // );

      setInterval(async () => {
        const data = await spotifyApi.refreshAccessToken();
        const access_token = data.body['access_token'];

        // console.log('The access token has been refreshed!');
        // console.log('access_token:', access_token);
        //res.cookie("code",access_token);
        spotifyApi.setAccessToken(access_token);
      }, expires_in / 2 * 1000);
    })
    await spotifyApi.getMe().then(function(data){ // set your username?
      req.session.name = data.body.display_name;
      req.session.n= 1;
    })
    //var result = await spotifyApi.getMe()
    .catch(error => {
      console.error('Error getting Tokens:', error);
      res.send(`Error getting Tokens: ${error}`);
    });
  //console.log(req.session.access);
  //setname(req,res);
  res.render('index.html', { title: 'Logged in!'});
});

router.get('/userinfo', async (req,res) => {
    try {
      var result = await spotifyApi.getMe();
      console.log(result.body);
      res.status(200).send(result.body)
    } catch (err) {
      res.status(400).send(err)
    }
});
// this might work haha ?
router.get('/logout' , async (req,res) => { // I don't think this is good
  req.session.access=undefined;
  req.session.refresh=undefined;
  req.session.name="Not Logged In";
  req.session.n=undefined;
  setname(req,res);
  res.render("base.html",{ title: 'Logged out!' ,contents:"You've successfully logged out! now get tf outta here "});
});

router.get('/saved', async (req,res) => {
  var x = checklogin(req,res);
  if (!x){ // if not logged in get kicked to a login page, otherwise actually do the stuff in this route... this is ghetto ... LOL
    res.render('base.html', { contents: 'Please log in! ' });
  } else {
  await spotifyApi.getUserPlaylists()
  .then (function(data) {
      console.log("successful retrival? " + data)
      console.log(JSON.stringify(data.body.items, null, 2));
      res.render("saved.html",{lists:data.body });
    })
    .catch(function(err) {
      console.log("error lol" + err.message);
    });
  }
});
router.get('/me', async(req,res)=>  {
  var x= checklogin(req,res);
  if (!x){ // if not logged in get kicked to a login page, otherwise actually do the stuff in this route... this is ghetto ... LOL
    res.render('base.html', { contents: 'Please log in! ' });
  } else {
  var result = await spotifyApi.getMe()
  console.log(result)
  res.redirect("/");
}
});
router.get('/register', async(req,res) => {
  res.render('register.html', { title: 'Express' });

});
router.get('/create', async(req,res) => {
  var x = checklogin(req,res);
  if (!x){ // if not logged in get kicked to a login page, otherwise actually do the stuff in this route... this is ghetto ... LOL
    res.render('base.html', { contents: 'Please log in! ' });
  } else {
  if (req.method == 'POST') {
    var body="";
    req.on('data', function (data) {
      body += data;
      if (body.length > 1e6)
               request.connection.destroy();
       });

       request.on('end', function () {
           var post = qs.parse(body);
           // use post['blah'], etc.

       });
    console.log(post['inp']);
    }
    res.render('create.html', { title: 'Express' });

  }});
router.post("/create", async(req,res) => {
  var result = ""
  spotifyApi.searchTracks(req.body.inp).then(
    function(data) {
      console.log("DATA recieved");
      result=data.body;
      console.log(result);
      console.log(result.tracks.items);
      if (result.tracks.items.length == 0) {
        // no results found ,error :)
        console.log("ERROR no tracks?")
        res.render("base.html",{contents:"Error, no results returned"});
      }else {

        res.render("searchresults.html",{results:result.tracks.items, title:"search results"});
      }
      //console.log(JSON.stringify(result.tracks.items, null, 2));

    },
    function(err) {
      console.log("error", err);
      result = "ERROR OCCURED sadge"
      res.render("base.html",{contents:result})
    }
  );

  //res.redirect("/create");
});
// the meat of what the app promised ... :)
router.get("/linky", async(req,res) => {
  var x= checklogin(req,res);
  if (!x){ // if not logged in get kicked to a login page, otherwise actually do the stuff in this route... this is ghetto ... LOL
    res.render('base.html', { contents: 'Please log in! ' });
  } else {
  var id = req.query.id;
  var type = req.query.type; // what is being passed in ?
  songs = [] // start adding songs to a list, and add that to a palylist at the end...
  // from this, we have some things to do
  var r
  var artist
  await spotifyApi.getArtist(id).then(function(data) {
    //console.log("artist", data.body);
    artist = data.body.name;
    return data.body.id;
  })
  .then(function (artistid) {
    return spotifyApi.getArtistTopTracks(artistid,"US") // hmm I guess this only works in the US for now ? or track rating from the US? Idk how this works
  })
  .then(function (data) {
    for (track in data.body.tracks) {
      console.log(data.body.tracks[track])
      songs.push("spotify:track:" + data.body.tracks[track].id); // idk if this syntax is correct : )
    }
    //console.log(data.body);
  });
var lz;
  await spotifyApi.createPlaylist(artist + " playlist", { 'description': 'playlist generated by playlister!!' , 'public': true })
    .then(function(data) {
      console.log('Created playlist!');
      console.log(data);
      lz = data.body.id;
    }, function(err) {
      console.log('Something went wrong!', err);
    });
    await spotifyApi.addTracksToPlaylist(lz, songs)
  .then(function(data) {
    console.log('Added tracks to playlist!');
  }, function(err) {
    console.log('Something went wrong!', err);
  });
// now we can getartistalbums or
// getartistrelatedtoartist
// getartisttoptracks

// getAlbumTracks
  // get similar songs  ( by genere)
  // flow is ->

  // get similar songs ( from same artist)
  // flow is -> artist -> ger artists related to artist -> top(?) songs

  // get similar songs ( something with the seeding setting? )

  //recommendations based on seeds
  // genre seeds ? ?? idk what this is

  //spotifyApi.createPlaylist
  res.render('base.html',{title:"playlist created",contents:songs})
  }
});
router.get('/saved2', async(req,res) => {

  res.render('saved.html', { title: 'Express' });

});
async function db_all(query){ // function with promise so that database data is waited for :) 
    return new Promise(function(resolve,reject){
        db.all(query, function(err,rows){
           if(err){return reject(err);}
           resolve(rows);
         });
    });
}
router.get('/about', async(req,res) => { // very important route, contains a majority of my points... :(
  console.log(req.query.inp);

  if (req.query.inp) {
    db.run(`INSERT INTO comments(dt) VALUES (\"${req.query.inp}\")`);
  }
  results = await db_all("SELECT dt FROM comments")
  res.render('about.html', { title: 'About' ,comments: results});
});

router.get('/tech', async(req,res) => {
  res.render('tech.html',{title:"Technologies used"})
});
// hosts the server lol
app.use(router)
app.listen(8888, "0.0.0.0", () => {
  console.log(`Listening to requests on http://localhost:8888`);
});
