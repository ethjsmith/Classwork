#include "Character.h"
# include <iostream>

using namespace std;
class ObjectPrinter {
	public:
	// a class that prints objects 
	static void print(const Character* c) // sending it the address of the character, which is much more efficent than copying it
	// set it to const yoyo
	{
		std::cout << "name = " << c->name << std::endl;
		std::cout << "strength = " << c->strength << std::endl;
		std::cout << "hitPoints = " << c->hitPoints << std::endl;
		//std::cout << "test" << std::endl;
		
	}// this is in the header, but that's just whatever... outside convention but LOL who cares.
};