from django.db import models
from django.contrib.auth.models import User



class Post(models.Model):
    id = models.AutoField(primary_key=True)
    poster = models.ForeignKey(User, on_delete=models.CASCADE)
    title = models.TextField() # could be Char field instead ?
    content = models.TextField() # Text field has no max length, and even if you set one, it isn't enforced LOL
    image = models.ImageField(upload_to='media/images', null=True, blank=True)
    type = models.IntegerField()
    #I think django has a builtin date field
    posted = models.DateTimeField()

    def __str__(self):
        return f"{self.title}: by {self.poster}"

class Comment(models.Model): #TODO check if cascade delete works as intended
    id = models.AutoField(primary_key=True)
    poster = models.ForeignKey(User, on_delete=models.CASCADE)
    article = models.ForeignKey(Post, on_delete=models.CASCADE)
    content = models.TextField()
    posted = models.DateTimeField()

class Member(models.Model):
    # this basically just extends the builtin user class, allowing permissions, so that only people with a certain power level can create announcements vs blog posts vs comments
    # also adds all of the notification functionality and ability to set a profile picture, which is one of our requirements.
    id = models.AutoField(primary_key=True)
    user = models.OneToOneField(User,on_delete=models.CASCADE)
    permission = models.IntegerField(null=True,blank=True,default = 0)
    email = models.TextField(null=True,blank=True)
    phone = models.TextField(null=True,blank=True)
    email_notif = models.BooleanField(null=True,blank=True,default = False)
    phone_notif = models.BooleanField(null=True,blank=True,default = False) # putting this extra thing in in case we need it
    image = models.ImageField(upload_to='media/images', null=True, blank=True,default='media/images/default_pfp.jpeg') # I don't know how this works, but I'm adding it :)
    def __str__(self):
        return f"{self.id}, {self.user}, {self.permission}, {self.email}, {self.phone}, {self.phone_notif}"

# creating the database looks like this
#`python manage.py makemigrations SystemsAnalysis`
#`python manage.py migrate `
#`python manage.py shell`

#then you can insert some data into the db with
#`from SystemsAnalysis.models import Post, Comment, Member, Image `

# and then start creating sample data.
