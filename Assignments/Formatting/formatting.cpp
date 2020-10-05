/*  Created/edited by: Ethan Smith
*   Assignment: Formatting output with COUT
*   date: 9/17/2020
*   Class: 3150
*   Favorite Color: RED
*/
/******************************************************************************

All program submissions need a correct header...

*******************************************************************************/

#include <iostream>
#include <iomanip>
//Make sure to add the library needed to use the set commands

//line missing

// :^)

using namespace std;
int main()
{
    cout<<"The following output should be in columns 10 chars wide." << endl;
    cout<<"Numbers should all be displayed with two decimal places only (no changing the numbers)." << endl;
    cout<<"End the output with a row of *'s the exact length of the output." << endl;
    
    cout << setw(10) << "Column 1"<< setw(10)<<"Column 2"<< setw(10)<<"Column 3" << endl;
    cout << setw(10)<< setprecision(2) << 3.14558<< setw(10)<< 3.0/8.0 << setw(10)<< 789 << endl;
    cout << setw(10)<<8.4526585<< setw(10)<< 7.1212 << setw(10)<< 5.6 << endl;
    cout << setfill('*') << setw(30) << "*" << endl;
    
    cout << "Print out the word fab by converting the base 10 numbers to hexadecimal"<< endl;
	//you have to use the hex value to get credit for this
    
    cout << setbase(16) << 15 << 10 << 11 ;
   
}
