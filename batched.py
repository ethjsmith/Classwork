import pyglet
import sys, time, math
from euclid import * # i don't think Im using this right now
from random import *

# physics object, basically just an extended sprite, with velocty, and an update method that moves the object
class PhysicsObject(pyglet.sprite.Sprite):

    def __init__(self, *args, **kwargs):
        super().__init__(*args,**kwargs)

        self.velocity_x = 0.0
        self.velocity_y = 0.0

    def update(self, dt): # dt is "delta time" ( or the time step... this looks a bit like calc and I dont like it )
        self.x += self.velocity_x * dt
        self.y += self.velocity_y * dt


#  sets anchor point correctly to center of img, instead of edge
def center(img):
    img.anchor_x = img.width // 2
    img.anchor_y = img.height // 2

# generates a number of particles at a point, and defines their movement behavior
def generator(num, source_coords):
    obj = []
    for i in range(num):
        x,y = source_coords
        newParticle = PhysicsObject(img=img_fire,x=x,y=y,batch=fire_batch)
        # particle behavior is declared here , also right now the generator creates only a set number of particles
        newParticle.velocity_x = (random()-.5)*50
        newParticle.velocity_y = (random()-.5)*50
        obj.append(newParticle)
    return obj

# function to allow all objects to change. relies on the fact that a is a public variable holding a list of PhysicsObjects
def update(dt):
    for obj in a:
        obj.update(dt)

pyglet.resource.path = ['images'] # lol
pyglet.resource.reindex()

img_fire = pyglet.resource.image("fire.png")
center(img_fire)
game_window = pyglet.window.Window(800,800)

fire_batch = pyglet.graphics.Batch()
if len(sys.argv) < 2:
    print("enter a number of sprites to generate, up to about 20000")
    exit()
a = generator(int(sys.argv[1]),[400,400]) # generates 10 particles, centered at 50,50
# WHY tf does pyglet use a standard catesian graphing coordinate system?? NOBODY does that

@game_window.event
def on_draw():
    game_window.clear()
    fire_batch.draw() # draws as a batch, which is the entire point of this program, over fre.py

if __name__ == "__main__":
    pyglet.clock.schedule_interval(update,1/120.0) # runs the update function regularly to update object locations
    pyglet.app.run()
