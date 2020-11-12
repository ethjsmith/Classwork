from django.contrib.auth.decorators import login_required
from django.contrib.auth.forms import UserCreationForm
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy

from gameRec.models import *
import operator

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
    g2 = Game.objects.all()
    context = {
        "word":"Reccomendation page!",
        "games":g2,
    }
    return render(request,"getRect.html",context)

def rec(request,id=0):
    g2 = []
    print("id is :" + str(id))
    if id == "0":
        print('id is 0')
        g2 = Game.objects.filter(gamer=request.user.id)
    else:
        g2 = Game.objects.filter(id=id)
    t = Tag.objects.filter(name = get_similar_game(g2)) # this might be id instead ...
    # this has changed from a single string, to a list of tag objects... todo
    #
    #   TODO Fix this area ...
    #
    if id == "0":
        #allsuggest = Game.objects.filter(tag=t[0]).exclude(id__in=[o.id for o in g2]).all()# for in g2.id).all()
        allsuggest = Game.objects.filter(tag__in=[t2 for t2 in t]).exclude(id__in=[o.id for o in g2]).all()# for in g2.id).all()

    else:
        allsuggest = Game.objects.filter(tag=t[0]).exclude(id=id).all()
    print(allsuggest)
    if allsuggest == []: # technically this is a kind of hacky fix, that doesn't work particularly great
    # one thing that could be added : if someone has all games of a particular type, this would also fire, so some kind of elif statement to suggest a new "genere/tag"
        w = "We have no games to reccomend, you must have all, or most of the games in our database"
    else:
        w = "We recommend:"
    context = {
        "word":w,
        "yourgames":allsuggest,
    }
    return render(request,"displayAllGames.html",context)

@login_required
def user_games(request):
    if request.method == 'POST':
        request.user.gamer.games.add(request.POST.get('newGame'))
        request.user.save()
        # adds a new game to your list of games

    gm = Game.objects.filter(gamer=request.user.id)
    g2 = Game.objects.all()
    context = {
        "word":"your games!",
        "yourgames":gm,
        "games":g2,
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
        "yourgames":gm,
    }
    return render(request,"displayAllGames.html",context)

def get_similar_game(games_l):
    # for games in the games list, count up the total of each "tag", and then select the highest rated game with that tag

    print(games_l)
    print ("above are the games I got ")
    tags = {}
    for g in games_l: # this might need modification, what if a single game is passed in?
        print (g)
        for tag in g.tag_set.all():
            if tag in tags:
                tags[tag] = tags[tag] + 1 # increment the tag counter
            else:
                tags[tag] = 1 # create a new tag with a count of one

    #max(tags.items(), key=operator.itemgetter(1))[0] # this should be the name of the tag with the highest count ?
    #print(tags)
    ret = max(tags, key=lambda key: tags[key]) # using a lambda monkaW
    #{print(k + ":" +  v) for k, v in sorted(tags.items(), key=lambda item: tags[1])}
    sorted_d = dict(sorted(tags.items(), key=operator.itemgetter(1),reverse=True))
    #print(sorted_d)
    #print (ret)
    #return ret
    return sorted_d
    # does this return only a signle tag? it should return the tags in an ordered list based on count, so that if the first tag has no valid results, you can continue, and try the subsequent tags in the list
