/*
*   Ethan Smith
*   Pointers1 assignment
*   Driver File
*   C/C++ programming
*   10/30/2020
*/
#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <cstdlib>

#include "Customers.h"
#include "CustomersFunctions.cpp"

using namespace std;
// Accepts as command line input a customer id and balance
// Create a customer using command line arguments and test your CustomerFunctions.cpp functions

int main(int argc, char* argv[]) {// accepts name, id, and balance ... 
    for (int z = 0; z < argc; z++){
		cout << argv[z] << endl;
        }
}
    if (argc < 4) {
        cout << "not enough arguments, be sure to add Name, id, and balance" << endl;
        exit(1);
    }
    int x = atoi(argv[2]);
    double y = atof(argv[3]);
    // create a customer from cli arguments 
    struct Customer c = {argv[1],x,y};
    // c.name = argv[1];
    // c.id = x;
    // c.balance =y ;

    
    print(&c);
    charge(&c, 25.00);
    charge(&c, 999999.00);
    print(&c);
    
    //charge (&d);
    // that's not required to work 
    //print(&d);
}