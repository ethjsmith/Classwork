/*
* Modified by Ethan Smith
* 10/5/20
*/
/*In the end this file will contain your planet namspace*/
# ifndef PLANETS_H
#define PLANETS_H


//move to Planets.h

namespace grav {
	
enum Planet{sun, jupitar, neptune, saturn, earth, uranus, venus, mars, mercury, moon, pluto};
	
//move to planets.h
struct Gravity {
const double Sun     =	274.00;
const double Jupiter =  24.92;
const double Neptune =	11.15;
const double Saturn	 =  10.44;
const double Earth	 =  9.798;
const double Uranus  =	8.87;
const double Venus	 =  8.87;
const double Mars	 =  3.71;
const double Mercury =	3.7;
const double Moon	 =  1.62;
const double Pluto	 =  0.58;
};
}
#endif