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

using namespace std; 


class Character
{
	private: 
		string name;
		int strength;
		int hitPoints;
		enum STATUS {ALIVE, DEAD};
		STATUS status;
		
	public: 
	
		//How many different types of constructors will this allow for?
		Character(string name = "John Doe", int strength=1, int hitPoints=1): 
			name(name), strength(strength), hitPoints(hitPoints){charNum++; status=ALIVE;}

		~Character(){cout << "Object destroyed " << endl;}
	
		//What is the purpose of making this variable static?
		static int charNum;

		void print();
		
		//int getHitPoints();
		//int getStrength();
		//bool isAlive();
		//void takeDamage(int);
};

//Why is this here outside the class?
int Character::charNum =0; 

void Character::print()
{
	cout << "name = " << name << endl;
	cout << "strength = " << strength << endl;
	cout << "hitPoints = " << hitPoints << endl;
}


int main()
{
	Character c1;
	Character c2("Bob the plumber", 56, 100);
	c1.print();
	c2.print();

	cout << Character::charNum <<endl;
}




