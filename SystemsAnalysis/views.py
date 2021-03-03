from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy

from SystemsAnalysis.models import *
import operator  # I just imported everything from an older project :^)
from SystemsAnalysis.forms import ImageForm, UserData,Article

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
    context = {
        "word":"Welcome to the SUU cyber website "
    }
    return render(request,"base.html",context)

def posts(request,type=0):# arg set so you only have to set it for announcements ?
    if type =="1":
        print("select and display articles")
        #return render (request, 'base.html',c) # placeholder, this will *probably* error
        return render(request,"base.html",{"word":"Announcements :)"})
    elif type == "0":
        print("select and display announcements")
        #return render (request, 'base.html',c)
        return render(request,"base.html",{"word":"Blog Posts :)"})
    else:
        # this is an error state
        return render(request,"base.html",{"word":"ERROR :)"})

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
        else:
            print("FORM NOT VALID LOLOL!!!!")
    else:
        form = UserData()
    return render(request,"form.html",{'form':form})
@login_required
def notifications(request):
    context = {
        "word":"update notification settings here"
    }
    return render(request,"base.html",context)
@login_required
def create(request):
    if request.method == 'POST':
        form = Article(request.POST)
        if form.is_valid():
            print("resolve input ")

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
