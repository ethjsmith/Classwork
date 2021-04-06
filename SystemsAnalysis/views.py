from django.contrib.auth.decorators import login_required, user_passes_test
from django.contrib.auth.forms import UserCreationForm
from django.contrib import messages
from django.shortcuts import render, redirect
from django.http import HttpResponse, JsonResponse
from django.views import generic
from django.urls import reverse_lazy
from django.contrib.auth.signals import user_logged_in


from SystemsAnalysis.models import *
import operator , datetime, threading # I just imported everything from an older project :^)
from SystemsAnalysis.forms import UserData,Article,Addcomment
from SystemsAnalysis.notification import validateEmail, sendEmail,sendNotification

class SignUpView(generic.CreateView):
    form_class = UserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'registration/signup.html'

def makeNewMember(sender,user,request,**kwargs):
    messages.add_message(request,messages.INFO, "Successful login!")
    print("A user has logged in, checking if they have a member")
    q = Member.objects.filter(user=user)
    if len(q) > 0:
        print("profile exists")
    else:
        print("making a new member profile ")
        z = Member(user=user,permission=0)
        z.save()
    # yep
user_logged_in.connect(makeNewMember) # this checks if you have a member account every time a user logs in

def allo(user):
    z = Member.objects.filter(user=user)
    print(z)
    if int(z[0].permission) == 1:
        print("successful allo test")
        return True
    return False

@login_required
def me(request):
    m = Member.objects.filter(user=request.user)
    return render(request,"userPage.html",{"member":m[0]})

@login_required
@user_passes_test(allo)
def testview(request):
    a = Member.objects.all()
    g = ""
    for u in a:
        print(u)
        g = g + str(u)
    return render(request,"base.html",{"word":g})

@login_required
#@user_passes_test(allo,login_url="/")
def adm(request):
    # selects all the data
    u = User.objects.all()
    p = Post.objects.all()
    c = Comment.objects.all()
    return render(request, "admin.html",{"users":u,"posts":p,"comments":c})

@login_required
#@user_passes_test(allo,login_url="/")
def makeadmin(request,id,power): # this whole section might not work kekw
# you pass in the user id, and the new admin power so IE /makeadmin/1/1 makes userid 1 have power 1 ( they are admin)
# and /makeadmin/4/0 takes adminpowers away from userid 4...   /makeadmin/3/6 might work I don't remember how admin is checked if its ==1 or >0
    u = User.objects.filter(id=id)
    r = Member.objects.filter(user=u[0])
    t = r[0]
    t.permission = power
    # print(f"setting {t}'s power to {power}")
    t.save()
    return redirect("/admin")

@login_required
@user_passes_test(allo,login_url="/")
def dele(request,type,id):
    # an engine for deleting user content, only available to admins
    if type == "comment":
        z = Comment.objects.filter(id=id).delete()
    elif type == "post":
        z = Post.objects.filter(id=id).delete()
    elif type == "user":
        z = User.objects.filter(id=id).delete() # I don't know if this one will work kek
    else:
        println("error ")
    return redirect("/admin") # go back to whatever page sent you, which I haven't made yet so rn it doesn't do that .

def home(request):
    return render(request,"base.html",{"word":"Welcome to the SUU cyber website "})

def posts(request,type=0):# arg set so you only have to set it for announcements ?
    pst = Post.objects.filter(type=type)
    return render(request,"overview.html",{"articles":pst}) # LOL this is ... good

def contact(request):
    admins = Member.objects.filter(permission=1)
    word = "To get in contact with the club, you can email us at suucdcclub@gmail.com, or you could contact the officers:"# # this is JUST BAD lol
    # for a in admins:
    #     u = a.user
    #     print(u)
    #     word += f"{u} at {a.email}"
    return render(request,"contact.html",{"word":word,"admins":admins})

def post(request,id=0):
    p = Post.objects.filter(id=id)

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
    c = Comment.objects.filter(article = p[0].id)
    c2 = []
    for co in c:
        op = Member.objects.filter(user=co.poster)
        c2.append(op[0])
    form = Addcomment()
    return render(request,"post.html",{"post":p[0],"comments":c,"member":c2,"form":form})

def article (request):
    context = {
        "word":"This is the handler page for an individual article"
    }
    return render(request,"base.html",context)


@login_required
def userpage(request):
    if request.method == 'POST': # handle form input here :) # this needs more work rn
        form = UserData(request.POST,request.FILES)
        u = request.user
        m = Member.objects.filter(user=u).first() #??
        if hasattr(u,"member") == False: # I don't think it's possible for this to run anymore, should probably remove
            ext = Member(user = u,permission= 0)
            ext.save()
        if form.is_valid():
            u.member.email_notif = form.cleaned_data['email_notify'] # this might be bad, it will set it regardless of if thats what you wanted?
            u.member.phone_notif = form.cleaned_data['phone_notify']
            if form.cleaned_data['email'] != "": # this is untested, but maybe will fix so you can leave fields empty :^)
                u.member.email = form.cleaned_data['email']
            if form.cleaned_data['phone'] != "":
                u.member.phone = form.cleaned_data['phone'] # might have to validate this, turn it into only numbers or something ?
            #TODO add the other untested fields to member
            if form.cleaned_data['profile_pic']:
                u.member.image = form.cleaned_data['profile_pic']
            else:
                print("no file, or file not valid??!?")
            u.member.save()
            if form.cleaned_data['name'] != "":
                u.username = form.cleaned_data['name']
                u.save()
            messages.add_message(request,messages.INFO, "User data updated")
        else:
            messages.add_message(request,messages.ERROR, "information not valid")
    else:
        form = UserData()
    return render(request,"user.html",{'form':form,'member':request.user.member})

@login_required
def notifications(request): # this function is really just a test of the notification system... mo
    context = {
        "word":"update notification settings here"
    }
    sendNotification('ethan@esmithy.net',"hello world")
    return render(request,"base.html",context)

@login_required
@user_passes_test(allo,login_url="/")
def create(request):
    if request.method == 'POST':
        form = Article(request.POST,request.FILES)
        if form.is_valid():
            print("resolve input ") # some kinds of data validation would be good ...
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
            ppl = Member.objects.filter(email_notif = True) # this will take a minute to run?
            threads = []
            if newArticle.type == 1:
                ty = "announcement"
            else:
                ty = "article"

            for p in ppl: # might work better if run as a subprocess? less waiting time probably
                t = threading.Thread(target=sendNotification, args=(p.email,f"A new {ty} has been posted on the SUU cybersecurity club site! It's called {newArticle.title}, and is written by {newArticle.poster}. Go check it out now!"))
                # threads.add(t)  # I don't know if this is required ... ?
                t.start()
                #sendNotification(p.email,"A new announcement has been posted on the cyber site! go check it out now!")

        else:
            messages.add_message(request,messages.ERROR, "Form data invalid! ")
    else:
        form = Article()
    return render(request,"form.html",{"form":form})
