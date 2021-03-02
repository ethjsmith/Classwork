# SystemsAnalysis
Repo for  IS3100 Systems Analysis and Design Project
if we build the site before we make the design documents, then we won't have to think much about the design documents :)

#TODO:

Development:
* [x] Initalize Django
* [x] make general template site
* [x] create database
* [ ] **Article logic ( announcements are/should just be renamed articles really )**
  * [x] page for generating new articles/announcements
  * [ ] page for displaying all articles/announcements
  * [ ] individual article page templates
  * [ ] commenting templates at the end of articles/announcements
* [ ] disable django built in admin? ( because I've never used it lol)
* [ ] **email/text notifications**
  * [ ] build email/text script
  * [x] figure out how it will attach to web app (IE how does script fire, do we need a database change for it ? )
  * [ ] integrate it into web app
* [ ] admin page
* [ ] initialize user accounts
* [ ] user comment engine

Deployment:
* if we self host
  * [ ] Deploy the site
  * [ ] DNS/web
    * [ ] DNS name
    * [ ] SSL cert  
  * [ ] Do all the NGINX BS
  * [ ] update the project into PROD mode ( disable debug lol)
* Additionally, if we host on a service(skips most of nginx pain):
  * [] learn how the web hosting service works

# Known Bugs:

* [ ] Fix logout functionality
