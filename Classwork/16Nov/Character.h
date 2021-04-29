#include <iostream>
#ifndef CHARACTER
#define CHARACTER
using namespace std;
class Character
{
	private: 
		string name;
		int strength;
		int hitPoints;
		enum STATUS {ALIVE, DEAD};
		STATUS status;
		//static int charNum;
	public: 
	
		//How many different types of constructors will this allow for?
		Character(string name = "John Doe", int strength=1, int hitPoints=1): 
			name(name), strength(strength), hitPoints(hitPoints){status=ALIVE;}

		~Character(){std::cout << "Object destroyed " << std::endl;}
	
		//What is the purpose of making this variable static?
		

		void print();
		
		friend class ObjectPrinter;
		//int getHitPoints();
		//int getStrength();
		//bool isAlive();
		//void takeDamage(int);
};
#endif