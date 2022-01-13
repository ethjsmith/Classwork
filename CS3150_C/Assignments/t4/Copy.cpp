/* (modified by ) Ethan Smith
 * C++ Final Practical
 * Copy constructor file
 * 12/16/20
 */


//Copy Constructor Practical
//Partially implemented big number class
//Add a copy constructor create deep instead of shallow copies

//Worth 10 Points

//tested on cpp.sh
//tested on https://www.onlinegdb.com/online_c++_compiler#

/*
Correct output:
2 2 2
3 3 3
4 4 4
*/


#include <iostream>

using namespace std;

const int maxNum = 3;

class BigNumber
{
	private:
	int * bn;

	public:
	BigNumber();
	BigNumber(int);
	BigNumber(BigNumber&); // copy constructor
	~BigNumber(){delete [] bn;}
	void print();
	void setAll(int);
};

BigNumber::BigNumber()
{

	bn = new int[maxNum];

	for (int x = 0; x < maxNum; ++x)
		bn[x] = 0;
}

BigNumber::BigNumber(int value)
	{
	    	bn = new int[maxNum];

	    for (int x = 0; x < maxNum; ++x)
		    bn[x] = value;
	}
BigNumber::BigNumber(BigNumber& n){ // deep copy constructor
	bn = n.bn;
}

void BigNumber::print()
{
	for (int x = 0; x < maxNum; ++x)
		cout << bn[x] << " ";
	cout << endl;
}

void BigNumber::setAll(int value)
	{
	    for (int x = 0; x < maxNum; ++x)
		    bn[x] = value;
	}


int main()
{
    //single value constructor
	BigNumber bn1(2);
	//constructor using assignment
	BigNumber bn2 = bn1;
	bn2.setAll(3);
	//constructor using another class object
	BigNumber bn3(bn2);
    bn3.setAll(4);

	bn1.print();
	bn2.print();
	bn3.print();
}
