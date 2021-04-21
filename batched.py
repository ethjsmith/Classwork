import pyglet
import sys, time, math
from euclid import *
from random import *

class PhyisicsObject(pyglet.sprite.Sprite):

    def __init__(self, *args, **kwargs):
        super().__init__(*args,**kwargs)

        self.velocity_x = 0.0
        self.velocity_y = 0.0

    def update(self, dt): # dt is "delta time" ( or the time step... this looks a bit like calc and I dont like it )
        self.x += self.velocity_x * dt
        self.y += self.velocity_y * dt

pyglet.resource.path = ['images'] # lol
pyglet.resource.reindex()

img_fire = pyglet.resource.image("fire.png")

def center(img):
    # sets anchor point correctly to center of img
    img.anchor_x = img.width // 2
    img.anchor_y = img.height // 2

center(img_fire)
game_window = pyglet.window.Window(800,800)

fire_batch = pyglet.graphics.Batch()

def generator(num, source_coords):
    obj = []
    for i in range(num):
        x,y = source_coords
        #newParticle = pyglet.sprite.Sprite(img=img_fire,x=x,y=y,batch=fire_batch)
        newParticle = PhyisicsObject(img=img_fire,x=x,y=y,batch=fire_batch)
        newParticle.velocity_x = random()*50
        newParticle.velocity_y = random()*50
        obj.append(newParticle)
    return obj

def update(dt):
    for obj in a:
        obj.update(dt)

a = generator(10,[50,50])

#update(a)

@game_window.event
def on_draw():
    # draw stuff
    game_window.clear()
    fire_batch.draw()
    # for x in a:
    #     x.draw()

if __name__ == "__main__":
    pyglet.clock.schedule_interval(update,1/120.0)
    pyglet.app.run()
