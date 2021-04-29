//Classes and inheritance Demo
//11-7-18
//Updated 11-30-20
//Dr. Gary Cantrell

#include <iostream>

using namespace std;


//1. Person class identify the elements of this class
class Person
{
	public :
		string name;
		char gender;

		Person();
		Person(string, char, int);
		~Person();
		void printObj();

	private :
		int id;

};

Person::Person() : name("BLANK"), gender('?'), id(000){}
Person::Person(string name, char gender, int id) : name(name), gender(gender), id(id) {}
Person::~Person(){}
void Person::printObj(){cout << "Name : "<< name << endl << "gender : " <<  gender << endl << "id : " << id << endl;}



//2. Date object class.... almost a struct
//add a birthDate to person and rearrange code to work properly

class Date
{
	public :
		int day;
		int month;
		int year;
		Date();
		Date(int, int, int);
		void printDate();
};

Date::Date() : day(0), month(0), year(0) {}
Date::Date(int day, int month, int year) : day(day), month (month), year(year) {}
void Date::printDate(){cout << "Month : "<< month << " Day : " << day << " Year " << year << endl;}



//3. Employee class inheriting from person class
//class subclass_name : access_mode base_class_name
//public mode - public becomes public; protected becomes protected
//protected mode - public becomes protected; protected becomes protected
//private mode - public becomes private; protected becomes private

class Employee : public Person
{
	public :
			Date StartDate;
			string title;
			Employee ();
			Employee(string, char, int, string, Date, double);
			~Employee();
			void printObj();

	private :
			double salary;
};



Employee::Employee() : title("BLANK"), salary(0) {}
Employee::Employee(string name, char gender, int id, string title, Date StartDate, double salary) : Person(name, gender, id), title(title), StartDate(StartDate), salary(salary) {}
Employee::~Employee(){}
void Employee::printObj(){Person::printObj(); cout << "title : " << title << endl; StartDate.printDate(); cout << "salary : "<< salary << endl;}


//4. Don't worry about Share Holder or boss yet go to main


//11. inheritance allowed: single; multiple; multilevel, hierarchical, hybrid
//12. What do these two classes create an opportunity for?
///return to main


class ShareHolder : public Person
{
	public:
		string stockPlan;
		ShareHolder();
		ShareHolder(string, int);
	private:
		int shares;
};

ShareHolder::ShareHolder() : stockPlan("BLANK"), shares(0) {}
ShareHolder::ShareHolder(string stockPlan, int shares) : stockPlan(stockPlan), shares(shares) {}



class Boss : public ShareHolder, public Employee
{
	public:
		int officeNumber;
		Boss();
		Boss(int, int);

	private:
		int bonus;
};

Boss::Boss() : officeNumber(0), bonus(0){}
Boss::Boss(int officeNumber, int bonus) : officeNumber(officeNumber), bonus(bonus){}



int main()
{

Person p1("Rob",'M',123);
p1.printObj();

//5. Create an instance of an employee
Employee e1("Bob", 'M', 0001, "Janitor", Date(1,1,1), 45000);
//How is this an example of linear inheritance and composition?

//6. Use printObj to show the information of employee
e1.printObj();
//What is this an example of

//7. Create an employee using a no argument constructor and add print statements to each no argument construtor
Employee e2;

//In what order are constructors called
//Test this with destructors as well

//8. Try to access a private object of the parent

//doesnt' work

//9. Change to protected and try again

// works

//10. Change public modifier to private and observe the result

//go back up to share holder

//13. Create a boss that is both a shareholder and an employee


//14. How do you distinguish between members variables that have the same name in two inherited classes?
//15. How do you call a method in the base class if your method is named the same as a method in the base class?


}
