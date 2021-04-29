# need to import the models so that models.model doesn't error :P
from django.db import models
from django.contrib.auth.models import User

# Pic, <-- not in database, but an image that shares it's name with the game
# theme, <-- This might be a tag... ( if we want it to be searchable anyways...)
# mechanics, <-- this is also probably a tag
# difficulty <-- int from 1 to 10?

class Game(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.TextField()
    # tags not needed here, as they can be accessed from either direction via the tags table. :)
    description = models.TextField(default="")
    difficulty = models.IntegerField(default=0)
    def __str__(self):
        return self.name

class Tag(models.Model):
    id = models.AutoField(primary_key=True)
    name = models.TextField()
    # description ?
    description = models.TextField(default="")
    games = models.ManyToManyField(Game)

    def __str__(self):
        return self.name


class Gamer(models.Model):
    id = models.AutoField(primary_key=True)
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    games = models.ManyToManyField(Game)
# I think there's some builtin user models... rather not rebuild those because they're a pain
