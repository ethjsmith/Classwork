Here's some useful dev stuff, for setting up and running the database.



creating a database from scratch: ( after a database change because im not fucking migrating a database with 3 entries in it) ( even though django makes that pretty easy )
```python
python manage.py migrate # possibly you don't even need this one :^)
python manage.py makemigrations gameRec
python manage.py migrate
```
Generate some random data for the database, ( for testing)
( first run `python manage.py shell` and then enter the following)
```python
from gameRec.models import Game, Tag, Gamer,User
# Create a generic user
u=User.objects.create_user('user', password='password')
u.save()
a = Game(name = "Catan",description="Settle the new world, and trade with other players ",difficulty = 4)# make some objects... all the other stuff is default right now
b = Game(name = "Monopoly",description="Classic capitalism simulator... not fun",difficulty=2)
c = Game(name = "Russian Roulette",description="death risking game of chance... great for the whole family",difficulty = 1)
d = Game(name = "BlackJack",description="bet against the dealer in this classic card game",difficulty =4)
e = Tag(name="Board",description="Games played on a board, usually for a smaller group")
f = Tag(name="Party",description="Games that are more suited to a party environment")
a.save()# save our objects into the database
b.save()
c.save()
d.save()
e.save()
f.save()
#g.save()
e.games.add(a)# link these tags, so that the games have these tags
e.games.add(b)
f.games.add(c)
f.games.add(d)
e.save()
f.save()
# turn our user into a GAMER!
g = Gamer(user=u)
g.save() # after this, all interaction with gamer is done through user
u.gamer.games.add(a) # add a couple games, so that this gamer has these games
u.gamer.games.add(b)
u.save()
exit()
```
