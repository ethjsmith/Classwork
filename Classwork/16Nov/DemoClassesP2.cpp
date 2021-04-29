//Examine the below code and be prepared to explain what it does
//Seperate character out to source and header files
//Create a separate class called ObjectPrinter
//Create a static method that will print a character
//Compile what happens?
//Make them friends
//Create a class within this file and include a private variable
//Try to access it from main
//Make main a friend and try again

#include <iostream>
#include "Character.h"
#include "ObjectPrinter.h"

using namespace std; 

int main()
{
	Character c1;
	Character c2("Bob the plumber", 56, 100);
//c1.print();
	//c2.print();
	ObjectPrinter::print(&c2);
	//cout << Character::charNum <<endl;
}




