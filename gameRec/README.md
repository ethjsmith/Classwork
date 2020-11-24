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

Generate some better data for the db ( is this testing?)

```python
from gameRec.models import Game, Tag, Gamer,User
# Create a generic user
u=User.objects.create_user('user', password='password')
u.save()
g1 = Game(name = "Settlers of Catan", description = "Collect and trade resources to build up the island of Catan in this modern classic.", difficulty = 5)
g2 = Game(name = "Scythe", description = "Five countries vie for dominance in a war-torn, mech-filled, steampunk 1920s Europe", difficulty = 7)
g3 = Game(name = "Concordia", description = "Lead your Roman dynasty and build the greatest trading empire in the Mediterranean.", difficulty = 6)
g4 = Game(name = "Codenames", description = "Give your team clever one-word clues to help them spot their agents in the field.", difficulty = 3)
g5 = Game(name = "Junk Art", description = "Travel the world, and create a masterpiece from eccentric pieces.", difficulty = 2)
g6 = Game(name = "Champions of Midgard", description = "Gain glory by defending a Viking harbor town against trolls, draugr and other beasts.", difficulty = 6)
g7 = Game(name = "Carcassonne", description = "Shape the medieval landscape of France, claiming cities, monasteries and farms.", difficulty = 4)
g8 = Game(name = "Gloomhaven", description = "Vanquish monsters with strategic cardplay. Fulfill your quest to leave your legacy!", difficulty = 8)
g9 = Game(name = "Kingsburg", description = "Grow your realm, influence members of the King's court and fight the forces of winter", difficulty = 5)
g10 = Game(name = "Wingspan", description = "Attract a beautiful and diverse collection of birds to your wildlife reserve.", difficulty = 5)
g11 = Game(name = "Terraforming Mars", description = "Compete with rival CEOs to make Mars habitable and build your corporate empire.", difficulty = 7)
g12 = Game(name = "War of the Ring", description = "The Fellowship and the Free Peoples clash with Sauron over the fate of Middle-Earth.", difficulty = 8)
g13 = Game(name = "Secret Hitler", description = "In pre-WW2 Germany, Liberals and Fascists square off in an intrigue-filled parliament.", difficulty = 3)
g14 = Game(name = "Decrypto", description = "Decipher your opponents' code before they decipher yours. Don't get caught.", difficulty = 4)
g15 = Game(name = "Tiny Epic Galaxies", description = "Roll your dice and colonize planets, utilizing your energy and culture.", difficulty = 4)
g16 = Game(name = "Exploding Kittens", description = "Ask for favors, attack friends, see the future- whatever it takes to avoid explosion! ", difficulty = 2)
g17 = Game(name = "Inis", description = "Claim the crown through merit and wisdom in this Celtic island struggle.", difficulty = 6)
g18 = Game(name = "Viticulture", description = "Create the most prosperous winery in Italy from the Tuscan vineyard you've inherited.", difficulty = 7)
g19 = Game(name = "Sheriff of Nottingham", description = "Sell goods for profit, or risk losing it all by slipping contrabands in....", difficulty = 4)
g20 = Game(name = "One Night Ultimate Werewolf", description = "An app-driven Werewolf that lasts but a single night. Wolves and villagers beware!", difficulty = 3)
g1.save()
g2.save()
g3.save()
g4.save()
g5.save()
g6.save()
g7.save()
g8.save()
g9.save()
g10.save()
g11.save()
g12.save()
g13.save()
g14.save()
g15.save()
g16.save()
g17.save()
g18.save()
g19.save()
g20.save()

t1 = Tag(name = "Worker Placement", description = "Take actions by placing workers in specific areas")
#Scythe, Champions of Midgard, Tiny Epic Galaxies, Viticulture, Kingsburg

t2 = Tag(name = "Dice rolling", description = "Roll some dice to determine different outcomes within the game")
#Settlers of Catan, Champions of Midgard, Kingsburg, War of the Ring,Tiny Epic Galaxies

t3 = Tag(name = "Battle", description = "Fight to win, whether it be against other players or the board itself")
#Scythe, Champions of Midgard, Gloomhaven, War of the Ring, Inis

t4 = Tag(name = "Party game", description = "Simple games to be played at a party")
#Codenames, Junk Art, Carcassonne, Secret Hitler, Decrypto, Exploding kittens, Sheriff of Nottingham, One night ultimate werewolf

t5 = Tag(name = "Engine building", description = "Build up your engine to run efficiently in order to win")
#Wingspan, Terraforming mars

t6 = Tag(name = "Social deception", description = "Lie to your friends for fun")
#Secret hitler, Sheriff of Nottingham, one night ultimate werewolf

t7 = Tag(name = "Economic", description = "Use quality resource management to come out on top")
#Catan, Scythe, Concordia, Kingsburg, Terraforming Mars, Tiny Epic Galaxies, Viticulture, Sheriff of Nottingham

t8 = Tag(name = "Card drafting", description = "Take turns picking a card until there are none left.")
#inis, terraforming mars
t1.save()
t2.save()
t3.save()
t4.save()
t5.save()
t6.save()
t7.save()
t8.save()

t1.games.add(g2)
t1.games.add(g6)
t1.games.add(g15)
t1.games.add(g18)
t1.games.add(g9)
t2.games.add(g1)
t2.games.add(g6)
t2.games.add(g9)
t2.games.add(g15)
t2.games.add(g12)
t3.games.add(g2)
t3.games.add(g6)
t3.games.add(g8)
t3.games.add(g12)
t3.games.add(g17)
t4.games.add(g4)
t4.games.add(g5)
t4.games.add(g7)
t4.games.add(g13)
t4.games.add(g14)
t4.games.add(g16)
t4.games.add(g19)
t4.games.add(g20)
t5.games.add(g10)
t5.games.add(g11)
t6.games.add(g13)
t6.games.add(g19)
t6.games.add(g20)
t7.games.add(g1)
t7.games.add(g2)
t7.games.add(g3)
t7.games.add(g9)
t7.games.add(g11)
t7.games.add(g15)
t7.games.add(g18)
t7.games.add(g19)
t8.games.add(g17)
t8.games.add(g11)
g = Gamer(user=u)
g.save() # after this, all interaction with gamer is done through user
u.gamer.games.add(g1) # add a couple games, so that this gamer has these games
u.gamer.games.add(g12)
u.save()
```
