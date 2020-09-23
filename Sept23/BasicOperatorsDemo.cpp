//Basic data types demonstration code
//9-8-19
//-Dr. G
//Tested on cpp.sh
//Edited 8/11/20


#include <iostream>
#include <climits>
#include <ctime>

using namespace std;

int main()
{
	//cout << sizeof(int) << endl;
	//cout << sizeof(unsigned int) << endl;
	//cout << sizeof(double) << endl;
	//cout << sizeof(char) << endl;
	//cout << sizeof(bool) << endl;
	//cout << sizeof(long) << endl;
	//cout << INT_MAX << endl;
	//int x = INT_MAX + 2 ;
	//cout << x << endl;
	bool f = true;
	cout << boolalpha << f;
	
}


//The fundamental data types between Java and C++ are basically the same.
//I'll skip some stuff.

//1. What actually happens when you declare a variable? Demonstrate size of.

//Why not just depend on standard sizes?

//2. What are the sizes for : int, float, double, unsigned int, char, bool
// The usefulness of this will become more apparent when we get to arrays. 

//3. Demonstrate the max size computed manually and through climits for int and uint.

//Which is larger? Why?

//4. Try to store a number 1 greater than allowed and observe the results
//5. Try to print a number larger than the max using INT_MAX and observe the results.
//6. Create a negative int and a negative uint.

//What does the unsigned int do?

/**** bool weirdness ******/

//7. Create a bool and print a bool. What do you observe?
//8. Add boolalpha to the stream and try again. What happens?
//9. Set a bool value to any number greater than one. Observe the results with and without
//the boolalpha flag set.

//10. Using cin get a bool as an input.

//10a. Use an int in an if statement

/**** char storage ****/

//11. Declare a char 'a'. Print its int value.
//12. Try some numeric operations on it.
//12a. How can we find out if C++ is representing chars as ASCII or Unicode?

/**** Constants ****/

//13. Create a constant variable and try to change it. 

//What's the difference in const and constexpr? (Tip: experiment with the time or random function)

/**** ternary operator ****/
//14. Review ternary operator syntax. 

//Chapter 5

//Skipping it for the most part but remember:
//There's an order to things
//Pre and post increment
//typecasting

