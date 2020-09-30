/*
Part of the Battle sequence ICE
8 - 18 - 2019
Dr. G
*/

#include "Character.h"
#include <iostream>

using namespace std;

int battleNum = 0; //Driver needs access to this value

//battle sequence fix the hit value
void battle (character c1, character c2)
{
	battleNum++;

	while (c1.state == alive && c2.state==alive)
	{
		int hitValue = 0;
		
		//c1 hits c2
		hitValue = 1; 
		c2.hitPoints -=hitValue;
		statusCheck(c2);
		
		//c2 hits c1
		if (c2.state==alive)
		{
			hitValue = 1;
			c1.hitPoints -=hitValue;
			statusCheck(c1);
		}
	}
	
	cout << "And the winner is :" ;
	if (c1.state == alive) cout << c1.name; else cout << c2.name;
	
}

//determine if the character should be alive or dead
void statusCheck(character c)
{
	if (c.hitPoints >= 0) c.state=alive; else c.state=dead;
}