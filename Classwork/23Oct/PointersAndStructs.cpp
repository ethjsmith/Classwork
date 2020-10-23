//One of the main usefulnesses of pointers is the ability to pass around 
//structs and class objects by address.

#include <iostream>

using namespace std;

struct Monster
{
	string name; 
	int hitPoints;
	string sounds[3]; 
};

//void printInfo(Monster &m) <-- this switches from pass by reference to pass by value 
void printInfo(Monster* m) //<-- now this is a pointer so it wouldn't work, we'd have to dereference the stuff later 
{
	cout << (*m).name << endl; // like this, but you can dereference with a shortcut, like on the next line ( member select ) 
	cout << m->hitPoints << endl;
	cout << m->sounds[0] << endl;
	cout << m->sounds[1] << endl;
	cout << m->sounds[2] << endl;
}

int main()
{
	
	Monster zombie1;
	zombie1.name="Karl";
	zombie1.hitPoints=99;
	zombie1.sounds[0]="Brains";
	zombie1.sounds[1]="gerrr";
	zombie1.sounds[2]="arggg";
	
	printInfo(&zombie1);
    
    //try to change something in the printInfo method and then reprint
    //what happened and what does that tell you
    //fix this with a reference variable
    //fix this with a pointer
	//use both dereference and member select
}

