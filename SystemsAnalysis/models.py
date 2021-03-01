from django.db import models
from django.contrib.auth.models import User

# does the standard user need to be extended? for now I don't think so

class Post(models.Model):
    id = models.AutoField(primary_key=True)
    poster = models.OneToOneField(User, on_delete=models.CASCADE)
    title = models.TextField() # could be Char field instead , which is more space efficent, but we're running this in sqlite3 so lol who cares. 
    content = models.TextField() # Text field has no max length, and even if you set one, it isn't enforced LOL
    image = models.ImageField() # I don't know how this works, but I'm adding it :)
    type = models.IntegerField()
    # should there be more, like a date ? I think django has built in dat functions
    posted = models.DateTimeField()

class Comment(models.Model):
    id = models.AutoField(primary_key=True)
    poster = models.OneToOneField(User, on_delete=models.CASCADE)
    article = models.ForeignKey(Post, on_delete=models.CASCADE)
    content = models.TextField()
    posted = models.DateTimeField()

class Member(models.Model): # this basically just extends the user class, allowing permissions, so that only people with a certain power level can create announcements vs blog posts vs comments
    id = models.AutoField(primary_key=True)
    user = models.OneToOneField(User,on_delete=models.CASCADE)
    permission = models.IntegerField()
