import pyglet
import sys, time, math
from euclid import * # i don't think Im using this right now
from random import *

# physics object, basically just an extended sprite, with velocty, and an update method that moves the object
class PhysicsObject(pyglet.sprite.Sprite):

    def __init__(self, *args, **kwargs):
        super().__init__(*args,**kwargs)
        self.startx = self.x
        self.starty = self.y
        self.velocity_x = 0.0
        self.velocity_y = 0.0
        self.life = 0
        self.maxlife = gauss(150,25)
        #self.die = time.time() + abs(gauss(0.0,100))
    def update(self, dt): # dt is "delta time" ( or the time step... this looks a bit like calc and I dont like it )
        self.life += gauss(10,6)
        self.x += self.velocity_x * dt
        self.y += self.velocity_y * dt
        if (self.x > 800) or (self.y > 800) or (self.life > self.maxlife):
            # self.life = 0
            # self.x = self.startx
            # self.y = self.starty
            self.re_init()
    def re_init(self):
        self.rotation = randint(0,360)
        self.velocity_x =(random()-.5)*50
        self.velocity_y =(random())*750
        self.x = self.startx
        self.y = self.starty
        self.life = 0
#  sets anchor point correctly to center of img, instead of edge
def center(img):
    img.anchor_x = img.width // 2
    img.anchor_y = img.height // 2

# generates a number of particles at a point, and defines their movement behavior
def genNew ():
    pz = PhysicsObject(img=img_fire,x=400,y=400,batch=fire_batch)
    return pz
def generator(num, source_coords):
    obj = []
    for i in range(num):
        x,y = source_coords
        x = gauss(x,34)
        y = gauss(y,32)
        newParticle = PhysicsObject(img=img_fire,x=x,y=y,batch=fire_batch)
        # particle behavior is declared here , also right now the generator creates only a set number of particles
        newParticle.velocity_x = (random()-.5)*50
        newParticle.velocity_y = (random())*750
        newParticle.rotation = randint(0,360)
        newParticle.scale_x = .1
        newParticle.scale_y = .1
        # this line makes a color based on how far the particle is from the emitter, further particles are more red, closer are more yellow/orange
        newParticle.color = (255,255-((abs(source_coords[0] - x) + abs(source_coords[1] - y))*2),0) # everything added in here makes the system look nicer, but run slower

        # x = 200
        (abs(source_coords[0] - x) + abs(source_coords[1] - y))/2
        # Y = 200


        obj.append(newParticle)
    return obj

# function to allow all objects to change. relies on the fact that a is a public variable holding a list of PhysicsObjects
def update(dt):
    t = time.time()
    for obj in a:
        obj.update(dt)
        # for i in range(len(a)-1,-1,-1):
        #     if (a[i].die <= t):
        #         #del a[i]
        #         a[i] = genNew()


pyglet.resource.path = ['images'] # lol
pyglet.resource.reindex()

img_fire = pyglet.resource.image("whitefire.png")
center(img_fire)
game_window = pyglet.window.Window(800,800)

fire_batch = pyglet.graphics.Batch()
if len(sys.argv) < 2:
    print("enter a number of sprites to generate, up to about 20000")
    exit()
a = generator(int(sys.argv[1]),[400,200]) # generates 10 particles, centered at 50,50
# WHY tf does pyglet use a standard catesian graphing coordinate system?? NOBODY does that

@game_window.event
def on_draw():
    game_window.clear()
    fire_batch.draw() # draws as a batch, which is the entire point of this program, over fre.py

if __name__ == "__main__":
    pyglet.clock.schedule_interval(update,1/120.0) # runs the update function regularly to update object locations
    pyglet.app.run()
