/* (modified by ) Ethan Smith
 * C++ Final Practical
 * operator overload file
 * 12/16/20
 */


//Operator Overload Practical
//Partially implemented big number class

//Worth 30 Points

//Complete the below so that main works
//tested on cpp.sh


#include <iostream>

using namespace std;

const int maxNum = 100;

//There's a limitation of the range of a number when stored as a primitive value
//This class allows you to store numbers up to 100 places long.
//This is only partially implemented.

class BigNumber
{
	private:
	int bn [maxNum];

	public:
	BigNumber(){for (int x =0; x<maxNum; x++) bn[x] = 0;}
	BigNumber& operator=(const BigNumber&); //set 1 big number to another big number
	BigNumber& operator=(const int []);//sets a 100 element array to a big number
	bool operator==(const BigNumber&);//determines if 2 100 element arrays are equal

	friend ostream & operator<<(ostream&, const BigNumber&);//prints out a big number
};

BigNumber& BigNumber::operator=(const BigNumber& b){for (int x = 0; x<maxNum; x++) bn[x]=b.bn[x]; return *this;}


/*			#1. IMPLEMENT PRINTING A BIGNUMBER	10 points		*/
// ??? bignumber.print()
ostream& operator<<(ostream& o, const BigNumber& b) {
		for (int x = 0; x < maxNum; ++x){
			o << b.bn[x] << " ";
		}
		o << endl;
		return o;
}

/*			#2. IMPLEMENT SETTING A BIG NUMBER TO A 100 ELEMENT ARRAY	10 points		*/
BigNumber& BigNumber::operator=(const int a[]){
		for (int x=0; x < 100; x++){
			bn[x] = a[x];
		}
}
/*			#3. IMPLEMENT THE EQUALITY OPERATOR BETWEEN TWO BIGNUMBERES	10 points		*/
bool BigNumber::operator==(const BigNumber& n){ // wont work
	for (int x = 0; x<maxNum;x++){
		if (bn[x] != n.bn[x]){
			return false;
		}
	}
	return true;
}

//Nothing in main needs to be changed, but comment out enough to make it compile and run
//if you aren't able to finish this file.
int main()
{
	BigNumber bn1;
	BigNumber bn2;
	BigNumber bn3;

	//Creates 456 in big number
	int a1 [100] = {0};

	a1[99] = 6;
	a1[98] = 5;
	a1[97] = 4;

	//check the equality operator
	bn1=a1;
	bn2=bn1;

	if (bn1==bn2) cout << "Equality test 1 Successful" << endl;
	if (!(bn1==bn3)) cout << "Equality test 2 Successful" << endl;
	cout << bn1 << endl; //should print the big number structure
}
