from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.contrib import messages
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy

from SystemsAnalysis.models import *
import operator , datetime # I just imported everything from an older project :^)
from SystemsAnalysis.forms import ImageForm, UserData,Article,Addcomment
from SystemsAnalysis.notification import validateEmail, sendEmail,sendNotification

class SignUpView(generic.CreateView):
    form_class = UserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'registration/signup.html'

def testview(request):
    a = Member.objects.all()
    g = ""
    for u in a:
        print(u)
        g = g + str(u)
    return render(request,"base.html",{"word":g})

def home(request):
    return render(request,"base.html",{"word":"Welcome to the SUU cyber website "})

def posts(request,type=0):# arg set so you only have to set it for announcements ?
    pst = Post.objects.filter(type=type)
    return render(request,"overview.html",{"articles":pst}) # LOL this is ... good

def post(request,id=0):
    p = Post.objects.filter(id=id)
    c = Comment.objects.filter(article = p[0].id)
    if request.method == "POST":
        form = Addcomment(request.POST)
        if form.is_valid():
            q = Comment(
                poster = request.user,
                article=p[0],
                posted = datetime.datetime.now(),
                content = form.cleaned_data['body']
            )
            q.save()
    form = Addcomment()
    return render(request,"post.html",{"post":p[0],"comments":c,"form":form})

def article (request):
    context = {
        "word":"This is the handler page for an individual article"
    }
    return render(request,"base.html",context)


@login_required
def userpage(request):
    if request.method == 'POST': # handle form input here :) # this needs more work rn
        form = UserData(request.POST)
        u = request.user
        if hasattr(u,"member") == False:
            ext = Member(user = u,permission= 0)
            ext.save()
        if form.is_valid():
            print("VALID FORM :) thats good ")
            print(form.cleaned_data)
            u.member.email = form.cleaned_data['email']
            u.member.email_notif = form.cleaned_data['email_notify']
            u.member.phone = form.cleaned_data['phone'] # might have to validate this, turn it into only numbers or something ?
            u.member.phone_notif = form.cleaned_data['phone_notify']
            u.member.save()
            print(u.member)
            messages.add_message(request,messages.INFO, "User data updated")
        else:
            print("FORM NOT VALID LOLOL!!!!")
            messages.add_message(request,messages.ERROR, "information not valid")
    else:
        form = UserData()
    return render(request,"form.html",{'form':form})
@login_required
def notifications(request): # this function is really just a test of the notification system... mo
    context = {
        "word":"update notification settings here"
    }
    sendNotification('ethan@esmithy.net',"hello world")
    return render(request,"base.html",context)
@login_required
def create(request):
    if request.method == 'POST':
        form = Article(request.POST,request.FILES)
        if form.is_valid():
            print("resolve input ")
            d = datetime.datetime.now()
            newArticle = Post(
                poster = request.user,
                title = form.cleaned_data['title'],
                content = form.cleaned_data['body'],
                image = form.cleaned_data['image'],
                type = form.cleaned_data['type'],
                posted = d,
            )
            newArticle.save()
            messages.add_message(request,messages.INFO, "New Article created!")
            ppl = Member.objects.query(email_notif = True) # this will take a minute to run?
            for p in ppl: # might work better if run as a subprocess? less waiting time probably 
                sendNotification(p.email,"A new announcement has been posted on the cyber site! go check it out now!")

        else:
            messages.add_message(request,messages.ERROR, "Form data invalid! ")
    else:
        form = Article()
    return render(request,"form.html",{"form":form})

# Image uploading function
def image_upload_view(request):
    """Process images uploaded by users"""
    if request.method == 'POST':
        form = ImageForm(request.POST, request.FILES)
        if form.is_valid():
            form.save()
            # Get the current instance object to display in the template
            img_obj = form.instance
            return render(request, 'testform.html', {'form': form, 'img_obj': img_obj})
    else:
        form = ImageForm()
    return render(request, 'testform.html', {'form': form})
