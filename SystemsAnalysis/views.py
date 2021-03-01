from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy

from SystemsAnalysis.models import *
import operator  # I just imported everything from an older project :^)

class SignUpView(generic.CreateView):
    form_class = UserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'registration/signup.html'

def home(request):
    context = {
        "word":"Welcome to the SUU cyber website "
    }
    return render(request,"base.html",context)
