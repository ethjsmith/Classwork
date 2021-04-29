#include "Character.h"
#include <iostream>

using namespace std;
//Character::charNum =0; 

void Character::print()
{
	std::cout << "name = " << name << std::endl;
	std::cout << "strength = " << strength << std::endl;
	std::cout << "hitPoints = " << hitPoints << std::endl;
}