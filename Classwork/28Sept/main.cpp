//Demo code for section S4
//-Dr. G
//9-15-19

//preprocessor directives
#include <iostream>
#include "functions.h"
#include "A_constants.h"
#include "B_constants.h"

//namespaces
using namespace std;

//function declarations/implementations
//void increase () {ACCUM++;}


// this is interesting, but fucking awful, why in gods name would you write something like this 
void increase2() {static int accum = 0; accum++; cout << accum << endl;}


int main()
{
	int ACCUM;
	//What kind of scope does this variable represent?
	int x = 0; 
	cout << x << endl;
	//1. create a block scope variable with a variable called x
	//print this variable within that scope and then print x again after that block
		{
			// sub scope
			int x = 12;
			cout << x << endl;
		
		}
	cout << x<< endl;
	//Does this have any use?
	
	//2. Uncomment the increase function. 
	//Create a variable ACCUM where it can be accessed by main or increase. 
	
	cout << ACCUM << endl;
	//increase();
	cout << ACCUM << endl;
		
	//3. Place this function and variable in another file. 
	//Should the ACCUM variable be in the h or functions.cpp?
	//How do you "link" the variable to this file?
	
	//4. Print my gravity from A_constants.h
	//Create your own my_gravity and see if it overides.
	//Use scope resolution to access the global constant.
	//Add the B_constants.h file
	//Now which gravity is used?
	//Make the define variable the same and observe the results. For fun.
	//How do we fix this?
	
	double MY_GRAVITY = 8.4;	
	//cout << A_CONST::MY_GRAVITY << endl;
	
	//Why are non-const global variables bad practice?
	
	//5. Call increase2 3 times. What is the output?
	//Change it so that accum value is kept.
	//How does this vary with global variables?
	
	increase2();
	increase2();
	increase2();

	//Note: I was unable to get my compiler to complain about implicit conversions
	//Note: I'm saving strings for a strings vs strings discussion later
	
	//6. Create a enum type for storing 4 types of monsters. 
	//Print each one. How are they actually stored?
	//What all does the previous question imply as to equality?
	//Create a variable of type monster and print it.
	//Reset the number system with -1 on the first monster and reprint. 
	//Does enum add any actual functionality?
	//Change it to an enum class and observe the results. 
	
	// I feel a strong dislike for enums
	enum uselessType {
		enumbs,
		chars,
	}
	
	//7. Create a couple of typedefs. 
	//At this level, what's the usefulness of this?
	
	//8. Create a student struct. 
	//Initialize the struct. 
	//What are the uses for a struct?
	//They are similar to what?
			
}



