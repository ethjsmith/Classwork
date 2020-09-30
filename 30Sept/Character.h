/*
Header file for a generic character
*/

#include<string>

struct character
{
	// fuck enums I hate them
	enum state {alive, dead};
	//bool alive;
	int hitPoints;
	int strength;
	
	character(int a, int hp, int s){
		//alive = a;
		state = alive;
		hitPoints = hp;
		strength = s;
	}
	
};

void statusCheck(character);
