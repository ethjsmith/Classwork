//Examine the below code and be prepared to explain what it does
//Seperate character out to source and header files
//Create a separate class called ObjectPrinter
//Create a static method that will print a character given a character pointer
//Compile what happens?
//Make them friends
//Create a function within this file that includes a print character method
//Try to access it from main
//Make that function a friend function within character

#include <iostream>
#include "Character.h"
#include "ObjectPrinter.h"

using namespace std; 

void print(Character* c)
	{
		std::cout << "name = " << c->name << std::endl;
		std::cout << "strength = " << c->strength << std::endl;
		std::cout << "hitPoints = " << c->hitPoints << std::endl;
	}

int main()
{
	Character c1;
	Character c2("Bob the plumber", 56, 100);
	
	ObjectPrinter::print(&c1);
	print(&c2);
	
	//c1.print();
	//c2.print();

	cout << Character::charNum <<endl;
}




