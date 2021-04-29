/*
*   Ethan Smith
*   Pointers1 assignment
*
*   C/C++ programming
*   10/30/2020
*/
#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;


bool charge(Customer* c, double v) {
    // charge() - accepts a customer pointer and reduces balance by sent double value, 
// returns true if successful and false if there aren’t enough funds. Use dereferencing.
if ((*c).balance >= v) {
    (*c).balance -= v;
    return true;
}
return false;
}

void print(Customer* c) {
    // print() - accepts a customer pointer and prints customer information or 
// prints an error message if the pointer currently points to null. Use member selection.
if ( c != NULL) {
    cout << "Name: " << c->name << endl;
    cout << "ID: " << c->id << endl;
    cout << "Balance: " << c->balance << endl;
}
else {
    cout << "ERROR: Customer is null, and does not exist" << endl;
}


}