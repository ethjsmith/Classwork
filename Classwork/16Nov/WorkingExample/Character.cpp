#include "Character.h"
#include <iostream>



void Character::print()
{
	std::cout << "name = " << name << std::endl;
	std::cout << "strength = " << strength << std::endl;
	std::cout << "hitPoints = " << hitPoints << std::endl;
}


//Why is this here outside the class?
int Character::charNum =0; 