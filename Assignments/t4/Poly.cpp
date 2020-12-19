/* (modified by ) Ethan Smith
 * C++ Final Practical
 * Polymorphism file
 * 12/16/20
 */


//Organize the following classe appropriately and successfully implement the polymorphic
//variable in the person class.
//Each line I changed I added a comment to it

//40 Points

#include <iostream>

using namespace std;

/* CREATE A LOGICAL CHAIN OF INHERITANCE AND CORRECTLY SET THE CHIME FUNCTION */

//Super class
class Clock{

	private:
		int hours;
		int minutes;
		int seconds;

	public:
		Clock(): hours(0), minutes(0), seconds(0){}
		Clock(int hours, int minutes, int seconds): hours(hours), minutes(minutes), seconds(seconds) {}

		//force all children of this class to have this function
		virtual void chime() = 0;
};

void Clock::chime(){cout << "SILENCE" << endl;} //This function should never be called


/* 5 POINTS */
//Analog is any Clock that doesn't use a dial
class Analog  : public Clock//LINE CHANGED
{
	public:
		Analog(): Clock(){}

		//Analog Clocks must all have a chime function. It's the way it is
		//Use this function to make this class abstract and force all children to have
		//this function
		virtual void chime()= 0;//LINE CHANGED
};

void Analog::chime(){cout << "ding" << endl;}


/* 5 POINTS */
//Digital is any Clock that uses a dial instead of a digital display
class Digital : public Clock //LINE CHANGED
{
	public :
		Digital (): Clock(){}

		//Digital Clocks may implement their own chime if they so chose
		//Change this line to allow for polymorphism, but this is will be instantiated
		void chime(); //LINE CHANGED
};

void Digital::chime(){cout << "Blink" << endl;}//LINE CHANGED


/* 5 POINTS */
//A watch worn on the wrist with a digital display
class DigitalWristWatch : public Digital //LINE CHANGED
{
	public:
		DigitalWristWatch(): Digital(){}
};


/* 5 POINTS */
//Old fashion grandfather Clock
class Grandfather : public Analog//LINE CHANGED
{
	public:
		Grandfather():Analog(){}
		void chime();
};

/* 5 POINTS */
void Grandfather::chime(){cout << "grandfatherly chime" << endl;}//LINE CHANGED


/* 5 POINTS */
//Old fashion analog cuckoo Clock
class Cuckoo : public Analog//LINE CHANGED
{
	public:
		Cuckoo():Analog(){}
		void chime();
};

void Cuckoo::chime(){cout << "bird pops out and chimes" << endl;}//LINE CHANGED



/* 10 POINTS */
//in this universe all persons have a Clock
/*   SET THIS CLASS UP SO YOU CAN ASSOCIATE ANY CLASS OF CLOCK WITH IT */
class Person
{
	public:
		Clock * clock;
		Person(Clock *c){
			clock = c;
		}
		//LINE CHANGED
		//LINE CHANGED
};

int main()
{
Cuckoo* ck = new Cuckoo;
DigitalWristWatch* dw = new DigitalWristWatch;
Grandfather* gf = new Grandfather;

Person p1(ck);
p1.clock->chime();//should chirp
Person p2(dw);
p2.clock->chime();//should blink
Person p3(gf);
p3.clock->chime(); //should dong

}
