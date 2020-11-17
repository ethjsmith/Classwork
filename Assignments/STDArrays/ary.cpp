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

	// at least
	// create one
	std::array<int,5> Stdarray; // std arrays are created like this, pretty poggers if I do say so myself
	// load one
	Stdarray = {1,2,3}; // stdarrays can be loaded like this, this method replaces anything in the array, so there are also 2 empty elements in the array in this case, which are initalized to zero
	// display contents

	// you can loop through std arrays using the len feature, or with a for loop like this.
	for (int element: Stdarray) {
		cout << element << endl;
	}
	cout << "the later elements are zero " << endl;
	// std arrays can do interesting things like first and last element access via member functions
	cout << "Last element: "<<Stdarray.back() << " First element: "<< Stdarray.front() << endl;
	// show some other functions
	// you can also check if the array is empty
	if (Stdarray.empty()){
		cout << "empty!" << endl;
	}
	else {
		cout << "not empty" << endl;
	}
}
