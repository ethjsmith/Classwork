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

// Create a customer file containing a struct with an string name, int id, and double balance

struct Customer {
    string name;
    int id;
    double balance;
    
};
bool charge (Customer* c);
void print(Customer* c);
