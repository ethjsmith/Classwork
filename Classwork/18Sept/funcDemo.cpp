/*
Demo code for functions in C++
Dr. G
8/5/2020
*/

#include <iostream>
#include "functions.h"
using namespace std;
// function prototype allows you to call functions before their scope occurs



int main()
{
	cout << add(7,4);
	// call whatever you want from this place right here yeehaw 
}


//1. Compile and test this code file alone with no changes
//2. Create an add function between "using" and  "main" : add(4,6)
//3. Move the function below main and observe the results. 
		//How is this different than in Java?
//4. Declare a function prototype (returnType function (type, type);)  and observe the results
//5. Demonstrate method overload
		//change the ints to doubles
		//why does this still work?
		//add an int and a double method
		//create an add(3.0,4);
		//which get's called?
		//Comment out the int, int function. What happens?
		
//Returning values and function arguments work the same as Java
//in general variable scope is the same as Java
//white space in C++ is irrelevant except for token seperation

//6. Place the add function in functions.cpp, but leave the prototype.
	//Recompile and test. 
	//Compile using "g++ -o add.exe funcDemo.cpp functions.cpp"  or
	//"g++ -o add.exe *.cpp"
	
	/*Intermediate step: Object files*/
	//Use the -c option to turn each cpp file into .o files: gcc -c "file.cpp"
	//What are the three phases of creating an exe with C++?
		//http://www.cplusplus.com/articles/2v07M4Gy/
	//What are these o files?
	//What's the benefit of being able to create them
	//How is it dealing with not being able to find all of it's "parts?"
	//How does this compare to Java?
	
//7. Remove the prototype and observe the results. What happens and why?
//8. Restore to working order by adding the function prototypes to the .h file and "including" them here.
//		Notice you have to include using "" not <> for a header file you created.

//9. Use the preprocessor directive "#define" to define a CAT as  "NEX." Print and observe the results
//10. Demonstrate the use of #ifdef #ifndef and #endif
	//What is a preprocessor directive and how is it different than a const?

//11. Protect the funcDemo.h file with a preprocessor directive

//steps 12-13 are in funcDemo.h