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
    g2 = [] # holds the games being passed into the selector function
    if id == "0": # if statement checks if you're going to pass in 1 game, or many
        g2 = Game.objects.filter(gamer=request.user.id)
    else:
        g2 = Game.objects.filter(id=id)
    t = get_similar_game(g2)
    print("here are tags" + str(t))
    possible_games = Game.objects.all().exclude(id__in=[o.id for o in g2])
    print("possible games: " + str(possible_games))
    t2 = list(t)
    print("tags as list: " + str(t2))
    #TODO: if there's no match from the first tag, move on to the second tag :)
    suggested_game = possible_games.filter(tag = list(t)[0]).all()
    while (not suggested_game and len(t) > 1):
        del t[list(t)[0]]
        print("all tags, minus first" + str(t))
        suggested_game = possible_games.filter(tag = list(t)[0]).all()
    #if (suggested_game):
    print("Game based on tags: " + str(suggested_game))
    #User.objects.all().order_by('date_joined', '-last_login')
    sg = suggested_game.order_by('difficulty')[:1]
    if not suggested_game:
    # one thing that could be added : if someone has all games of a particular type, this would also fire, so some kind of elif statement to suggest a new "genere/tag"
        w = "We have no games to reccomend, you must have all, or most of the games in our database"
    else:
        w = "We recommend:"
    context = {
        "word":w,
        "yourgames":sg,
    }
    return render(request,"displayAllGames.html",context)

@login_required
def user_games(request):
    u = request.user
    print (hasattr(u,"gamer"))
    if hasattr(u, "gamer") == False: # initalize the "GAMER" in you :)
        print ("making user into a gamer")
        newgamer= Gamer(user=u)
        newgamer.save()
    if request.method == 'POST':

        u.gamer.games.add(request.POST.get('newGame'))
        u.save()
        print ('added ' + request.POST.get('newGame'))
        # adds a new game to your list of games

    gm = Game.objects.filter(gamer=request.user.gamer.id) # error was here LOL was checking against the wrong ID so it worked if the user and gamer were in sync (RARE)
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
    test_view() # this tests some database stuff :^)
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
    #print(sorted_d)
    return sorted_d
    # does this return only a signle tag? it should return the tags in an ordered list based on count, so that if the first tag has no valid results, you can continue, and try the subsequent tags in the list
def test_view():
    # this isn't even a view lmao... its testing an odd bug

    u = User.objects.all()
    for usr in u:
        print(usr)
        if hasattr(usr,"gamer"): # if the user is linked to a gamer with games, print those
            for g in usr.gamer.games.all():
                print(g)
