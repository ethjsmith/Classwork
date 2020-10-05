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
 
//bool d = cin >> d;  // not syntaxically correcty 
cout << 0b10 << endl;  // read this number as binary
if (4) cout << "woot" << endl; // if true do x
cout << char('a' - 20) << endl; // outputs a difference char based on it's value
cout << 010 << endl; 
char a = 20;  cout << a << endl; // makes  a character that isn't standard ascii (char 20)  
#define while if // explained below
while (true) cout << "woot" << endl; // replaces while with if basically
cout << boolalpha <<  (0 ? "false" : "true") << endl; // that stupid way to write an if block, and prints true or false instead of the right way
cout << char(0x26) << endl; //display the char based on the hex value 
	
}



