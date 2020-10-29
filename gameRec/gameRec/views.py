from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy


# MonkaW class instead of function? couldn't be me!
class SignUpView(generic.CreateView):
    form_class = UserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'registration/signup.html'

def homepage(request):
    context = {
        "word":"Homepage!"
    }
    return render(request,"base.html",context)

@login_required
def recommend(request):
    context = {
        "word":"Reccomendation page!"
    }
    return render(request,"base.html",context)

@login_required
def user_games(request):
    context = {
        "word":"your games!"
    }
    return render(request,"base.html",context)


def user_register(request):
    context = {
        "word":"Register!"
    }
    return render(request,"base.html",context)

# this will be a test method to display all the games in the db
def showgames(request):
    
