from django.db import models
from django.contrib.auth.models import User

# does the standard user need to be extended? for now I don't think so

class Post(models.Model):
    poster = models.OneToOneField(User, on_delete=models.CASCASE)
    content = models.TextField()
    # should there be more, like a date ?

class Comment(models.Model):
    poster = models.OneToOneField(User, on_delete=models.CASCASE)
    article = models.OneToManyField(Post, on_delete=models.CASCASE)
    content = models.TextField()
