from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy

from SystemsAnalysis.models import *
import operator  # I just imported everything from an older project :^)
from SystemsAnalysis.forms import ImageForm

class SignUpView(generic.CreateView):
    form_class = UserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'registration/signup.html'

def home(request):
    context = {
        "word":"Welcome to the SUU cyber website "
    }
    return render(request,"base.html",context)

def posts(request):
    context = {
        "word":"see articles here"
    }
    return render(request,"base.html",context)

def article (request):
    context = {
        "word":"This is the handler page for an individual article"
    }
    return render(request,"base.html",context)


@login_required
def userpage(request):
    context = {
        "word":"Update your user info here "
    }
@login_required
def notifications(request):
    context = {
        "word":"update notification settings here"
    }
    return render(request,"base.html",context)
@login_required
def create(request):
    context = {
        "word":"create new articles or announcements here"
    }
    return render(request,"base.html",context)

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
