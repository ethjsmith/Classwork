/*
*	- Ethan Smith
*	- CS3150 Lab Extend animal
* - 12/4/2020
*/

// extending code from polymorphism demo in class
// Extend the animal class to include two other animals demonstrating hierarchical inheritance. (10 pts)
// Create a more specialized animal that demonstrates multiple level inheritance and function overload like animal->dog->husky.  (10 pts)
// Create an array of animals and make each animal in the array speak demonstrating polymorphism. (10 pts)
// Use good code quality and add enough comments to show you understand the concepts. (10 pts) // no


#include <iostream>

using namespace std;


//Animal super class
class Animal
{
	public :
		string name;
		virtual void speak()=0; // makes a function PURE virtual making the object an abstract class ( can never be instatianted)
		Animal();
		Animal(string);
		virtual ~Animal();

	private:
		int *p;
};

Animal::Animal(){/*cout <<" made animal" << endl;*/ name = "Generic"; p = new int;}
Animal::Animal(string name) : name(name) {}
Animal::~Animal(){cout << "animal now meat" << endl; delete p;}
void Animal::speak(){cout << "Grunt" << endl;}

//Horse inherits from animal
class Horse : public Animal
{
	public :
		void speak();
		Horse();
		Horse(string);
		~Horse();

	private :
		int *q;
};
Horse::Horse() : Animal(){/*cout <<" made horse" << endl;*/ q= new int;}
Horse::Horse(string name) : Animal(name) {}
Horse::~Horse(){cout << "horse go to glue factory" << endl; delete q;}
void Horse::speak(){cout << "Neigh" << endl;}


class Dog : public Animal {
public:
	virtual void speak(); // this is virtual so that bulldog can override it without ambiguity, but not =0 because dog isn't abstact ( in this implementation)
	Dog();
	Dog(string);
	~Dog();
	// dont think I actually need a int, that was just used to show destructor ordering
};
Dog::Dog(){
	name = "Good boy";
}
Dog::Dog(string s){
	name = s;
}
Dog::~Dog(){}// :^)
void Dog::speak(){
	cout << "Woof" << endl;
}
class Cat : public Animal {
public:
	void speak();
	Cat();
	Cat(string);
	~Cat();
	// dont think I actually need a int like in horse, that was just used to show destructor ordering importance
};
Cat::Cat(){
	name = "Good boy";
}
Cat::Cat(string s){
	name = s;
}
Cat::~Cat(){}// :^)
void Cat::speak(){
	cout << "Meow" << endl;
}
class Bulldog : public Dog {
public:
	void speak();
	// everything else is inherited from dog, so no need for contructors or anything in an example this simple
};
void Bulldog::speak(){
	cout << "growl" << endl;
}






int main() {

	// testing the all the animals to make sure they work
	Animal * a1 = new Horse();
	Animal * a2 = new Dog();
	Animal * a3 = new Cat();
	Animal * a4 = new Bulldog();
	a1->speak();
	a2->speak();
	a3->speak();
	a4->speak();

	Animal *ary[10]; // animal pointer array size 10
	for (int i=0;i<10;i++){
		int a = rand() % 4; // chose a random animal each time
		Animal* aa;
		if (a == 0){
			aa = new Horse();
		}
		else if (a == 1) {
			aa = new Dog();
		}
		else if (a == 2) {
			aa = new Cat();
		}
		else  {
			aa = new Bulldog();
		}
		ary[i] = aa; // add the animal to the array
		ary[i]->speak(); // make the animal speak ( from the array )
	}


}
