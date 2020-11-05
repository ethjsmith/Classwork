from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy

from gameRec.models import *

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
    if request.method == 'POST':
        # create a new link between current user and the selected game
        print(request)
    gm = Game.objects.filter(gamer=request.user.id)
    context = {
        "word":"your games!",
        "games":gm,
    }
    return render(request,"displayAllGames.html",context)


def user_register(request):
    context = {
        "word":"Register!"
    }
    return render(request,"base.html",context)

# this will be a test method to display all the games in the db
def showgames(request):
    gm = Game.objects.all()
    go = ""
    for g in gm:
        go = go + str(g) + ", "
    context = {
    #    "word":go,
        "games":gm,
    }
    return render(request,"displayAllGames.html",context)
