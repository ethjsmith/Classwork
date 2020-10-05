/*
* Modified by Ethan Smith
* 10/5/20
*/

#include "constants.h"
#include "planets.h"

//move to functions.cpp
double currentCal = 0;

//move to functions.cpp
double getGravity(grav::Planet planet)
{
	/*Tip: once you change Gravity to a namespace you no longer need a gravity variable*/
	
	grav::Gravity g;

	switch(planet){
		case 0 : return g.Sun;
		case 1 : return g.Jupiter;
		case 2 : return g.Neptune;
		case 3 : return g.Saturn;
		case 4 : return g.Earth;
		case 5 : return g.Uranus;
		case 6 : return g.Venus;
		case 7 : return g.Mars;
		case 8 : return g.Mercury;
		case 9 : return g.Moon;
		case 10 : return g.Pluto;
		default : return 0;
	}
}
//move to functions.cpp
void setCalories(double mass, grav::Planet planet, double distance)
{
	currentCal = mass * getGravity(planet) * distance * CALCONST;
}
