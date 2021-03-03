from django import forms
from .models import Image

class ImageForm(forms.ModelForm):
    class Meta:
        model = Image
        fields = ('title','image')
class UserData(forms.Form):

    # password = forms.CharField(label = "new password")
    # password2 = forms.CharField(label = "confirm new password")

    email = forms.CharField(label = "email address", max_length = 100)
    email_notify = forms.BooleanField(required = False)
    phone = forms.CharField(label = "phone number", max_length = 20) # hmm
    phone_notify = forms.BooleanField(required = False)
class Article(forms.Form):
    title = forms.CharField(label = "title")
    ty = (("article", "Article"), ("announcement", "Announcement"))
    type = forms.ChoiceField(choices=ty)
    body = forms.CharField(label = "body of article")
    image = forms.ImageField()
    # this needs some way to add the images... I almost wish we just hadn't done that lol
