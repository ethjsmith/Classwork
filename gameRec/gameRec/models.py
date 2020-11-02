# need to import the models so that models.model doesn't error :P
from django.db import models
from django.contrib.auth.models import User

class Game(models.Model):
    id = models.TextField(primary_key=True)
    name = models.TextField()
    # tags not needed here, as they can be accessed from either direction via the tags table. :) 
    def __str__(self):
        return self.name

class Tag(models.Model):
    id = models.TextField(primary_key=True)
    name = models.TextField()
    # description ?
    games = models.ManyToManyField(Game)

    def __str__(self):
        return self.name


class Gamer(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    games = models.ManyToManyField(Game)
# I think there's some builtin user models... rather not rebuild those because they're a pain
