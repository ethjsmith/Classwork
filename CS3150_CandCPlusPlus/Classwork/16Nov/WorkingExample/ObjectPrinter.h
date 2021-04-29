#ifndef OBJECTPRINTER
#define OBJECTPRINTER

#include <iostream>
#include "Character.h"

class ObjectPrinter
{
	
	public: 
	
	static void print(Character* c)
	{
		std::cout << "name = " << c->name << std::endl;
		std::cout << "strength = " << c->strength << std::endl;
		std::cout << "hitPoints = " << c->hitPoints << std::endl;
	}
	
};

#endif