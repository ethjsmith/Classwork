#ifndef CHARACTER
#define CHARACTER

#include <iostream>

class Character
{
	private: 
		std::string name;
		int strength;
		int hitPoints;
		enum STATUS {ALIVE, DEAD};
		STATUS status;
		
	public: 
	
		//How many different types of constructors will this allow for?
		Character(std::string name = "John Doe", int strength=1, int hitPoints=1): 
			name(name), strength(strength), hitPoints(hitPoints){charNum++; status=ALIVE;}

		~Character(){std::cout << "Object destroyed " << std::endl;}
	
		//What is the purpose of making this variable static?
		static int charNum;

		void print();
		
		friend class ObjectPrinter;
		friend void print(Character* c);
		
		//int getHitPoints();
		//int getStrength();
		//bool isAlive();
		//void takeDamage(int);
};



#endif