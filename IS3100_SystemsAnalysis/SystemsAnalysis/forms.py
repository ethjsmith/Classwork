from django import forms

class UserData(forms.Form):

    # password = forms.CharField(label = "new password")
    # password2 = forms.CharField(label = "confirm new password") # will fix this later or something idk
    #

    email = forms.CharField(label = "email address", max_length = 100,required=False)
    email_notify = forms.BooleanField(required = False)
    phone = forms.CharField(label = "phone number", max_length = 20,required=False) # hmm
    phone_notify = forms.BooleanField(required = False)
    # profile update stuff...
    # things that this should do : nickname/name change
    name = forms.CharField(label = "update your username", required=False)
    # add picture
    profile_pic = forms.ImageField(required=False)
    # contact info EZ/done


class Article(forms.Form):
    title = forms.CharField(label = "title")
    ty = ((0, "Article"), (1, "Announcement"))
    type = forms.ChoiceField(choices=ty)
    body = forms.CharField(widget=forms.Textarea(attrs={"rows":20, "cols":20}),label = "body of article")
    image = forms.ImageField()
    # this needs some way to add the images... I almost wish we just hadn't done that lol
class Addcomment(forms.Form):
    body = forms.CharField(widget=forms.Textarea(attrs={"rows":5, "cols":20}),label = "Enter a Comment!")
    # what a great form...
