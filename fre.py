
# example code for pyglet particle generation using a fire sprite

import sys, time, math
from pyglet.gl import *
from euclid import *
from random import *

window = pyglet.window.Window()

gravity = Vector3(0, -2, 0)

tex = pyglet.image.load('images/fire.png').get_texture()

batch = pyglet.graphics.Batch()
class par(pyglet.sprite.Sprite):
    def __init__(self,pos,batch=None,img=None):

        self.pos = pos.copy()
        self.pos[0] += gauss(0,25)
        self.pos[1] += uniform(0,40)
        self.vel = Vector3(uniform(-20,20), 300+gauss(0,50), 0)
        self.removeTime = time.time() + abs(gauss(0.0,0.25))
        pyglet.sprite.Sprite.__init__(self,img,batch=batch,x=self.pos[0],y=self.pos[1])
    def update(self,dt):
        self.pos += self.vel * dt
        self.vel += gravity * dt
        pyglet.sprite.Sprite.position += self.vel * dt

class particle:
   def __init__(self, pos):
       self.pos = pos.copy()
       self.pos[0] += gauss(0,25)
       self.pos[1] += uniform(0,40)
       self.vel = Vector3(uniform(-20,20), 300+gauss(0,50), 0)
       self.removeTime = time.time() + abs(gauss(0.0,0.25))
   def update(self, dt):
       self.pos += self.vel * dt
       self.vel += gravity * dt

class particleSystem:
   def __init__(self, num=1):
       self.particles = []
       self.addParticles(num)
   def addParticles(self, num):
       for i in range(0,num):
           p = particle(Vector3(300,100,0))
           self.particles.append(p)
   def draw(self):
       glColor3f(1,1,1)
       glEnable(tex.target)
       glBindTexture(tex.target, tex.id)
       glEnable(GL_BLEND)
       glBlendFunc(GL_ONE, GL_ONE)
       glBegin(GL_QUADS)
       for p in self.particles:
           size = 20
           glTexCoord2f(0,0)
           glVertex3f(p.pos[0]-size, p.pos[1]-size, p.pos[2])
           glTexCoord2f(1,0)
           glVertex3f(p.pos[0]+size, p.pos[1]-size, p.pos[2])
           glTexCoord2f(1,1)
           glVertex3f(p.pos[0]+size, p.pos[1]+size, p.pos[2])
           glTexCoord2f(0,1)
           glVertex3f(p.pos[0]-size, p.pos[1]+size, p.pos[2])
       glEnd()
       glDisable(GL_BLEND)
       glDisable(tex.target)
   def update(self, dt):
       for p in self.particles:
           p.update(dt)
       t = time.time()
       for i in range(len(self.particles)-1, -1, -1):
           if (self.particles[i].removeTime <= t) or (self.particles[i].pos[1] < 0):
               del self.particles[i]
               self.addParticles(1)
if len(sys.argv) < 2:
    print("enter a number of sprites to generate, up to about 20000")
    exit()
systems = [particleSystem(int(sys.argv[1]))]


@window.event
def on_draw():
   glClear(GL_COLOR_BUFFER_BIT)
#   batch.draw()
   for s in systems:
       s.draw()


def update(dt):
   for s in systems:
       s.update(dt)
   for i in range(len(systems)-1, -1, -1):
       if len(systems[i].particles) == 0:
           del systems[i]


pyglet.clock.schedule_interval(update,1/60.0)
pyglet.app.run()
