from django.contrib.auth.decorators import login_required
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse



def homepage(request):
    context = {
        "content":"Homepage!"
    }
    return render(request,"base.html",context)


def recommend(request):
    context = {
        "content":"Reccomendation page!"
    }
    return render(request,"base.html",context)


def user_games(request):
    context = {
        "content":"your games!"
    }
    return render(request,"base.html",context)


def user_register(request):
    context = {
        "content":"Register!"
    }
    return render(request,"base.html",context)


def user_login(request):
    context = {
        "content":"login!"
    }
    return render(request,"base.html",context)


def user_logout(request):
    context = {
        "content":"logout (this will just be a redirect lol, theres more code here than there needs to be)!"
    }
    return render(request,"base.html",context)
