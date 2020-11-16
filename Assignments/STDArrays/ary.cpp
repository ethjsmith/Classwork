/*
*	Ethan Smith
*	STD::array vs array
*	11/4/20
*/ 
#include <iostream>
#include <array> // gotta add this for std array... that is a difference I guess 

using namespace std; 

int main(){
// differences between array and std::array seem mostly to be that std::array supports copy semantics, so you can copy it into, our out of a function

int a1 [5] = {1,2,3,4,5};
std::array<int,5> a2 = {1,2,3,4,5};

cout << a1 << a2 << endl;
// at least 
// create one
std::array<int,5> Stdarray; // std arrays are created like this, pretty poggers if I do say so myself
// load one
Stdarray = {1,2,3}; // stdarrays can be loaded like this, this method replaces anything in the array, so there are also 2 empty elements in the array
// display contents 

// 
for (int element: Stdarray) {
	cout << element << endl;
}


// show some other functions

}