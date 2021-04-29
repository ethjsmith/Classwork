//Basic class constrution demo code
//11-10-2020
//Dr. G

#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std; 


//class declaration
class Character
{
    //What's a struct?
    //What's the difference in a struct and class?
    
    /* Part 1 : Basic Setup */
	//1. create a name, strength, and hitPoints for a character
	//2. create a character in main. Are variables public or private by default?
	//3. create a private and public section
	
	
	/* Part 2 : Constructors */
	//1. create a no argument constructor here and a single argument after main
	//2. create a no argument constructor here and a single argument constructor after main
	//3. create a print method and test
	//4. comment out the no argument constructor and test (set initial values)
	//5. comment out all constructors here and below and test
	//6. recreate the no argument constructors using an initializer list
	//7. create an all argument constructor with built in initializers
	
	/* Part 3 : Destructors */
	//1. create a destructor and test with block scope
	//2. dynamically create a class object then test the destructor with delete
	
	/* Part 4 : Copy constructor */
	
	/*
	
	A copy constructor is needed when "if an object has pointers or any runtime allocation 
	of the resource like file handle, a network connection..etc."
	
	The default copy constructor only does a shallow copy. User defined copy constructors
	are needed for deep copies.
	
	A copy contructor is called when a class is created using another class or
	when the assignment operator is used between class objects.
	
	*/
	
	
	//1. add an int element that is dynamically created within the class 
	//2. create two classes set 1 equal to the other or use one to constructor the other
	//3. set the value of the dynamically created variable in both to different values and print
	
	//What's going on?
	
	//4. create a copy constructor and re-test
	
    /* Part 5 : Static Variables */
	//5. Create a static variable and associated get function to keep up with the 
	//	  number of characters created. 
	//6. Prepare to fight create functions:take damage, get hit points, get strength, 
	//    is alive 
	//7. Create static fight function that accepts two characters
};

//class driver
int main()
{
}