//Array demo code for C++
//9-01-18
//Edited: 9-22-19
//-Dr. G
//Tested on https://www.onlinegdb.com/online_c++_compiler

#include <iostream>

using namespace std;

void zero(int [], int);

int main()
{
	
// this is how you declare an array 
//type name size
const int SIZE = 10;
//int size;
//cin >> size;

//1. Try initializing an array with SIZE and size
int x[SIZE]; 

//cout << sizeof(x) << endl;

//What does an index of 0 really mean?
float a[] = {2.3,5.6,6.9,5.3};

//2. Check sizeof a.
//cout << sizeof(a) << endl;

//3. How could we rewrite this to be the index size?
//create a for loop that will iterate through the array

//4. Check array contents with both initializations

//int y[SIZE]; <-- this uses whatever was there before
//int y[SIZE]={}; <-- this zeros out all the data in the array 

//for (int i = 0; i<SIZE; i++)
//	cout << y[i] <<endl;
	
//5. I haven't been able to get this to work like the example given, but try it anyway. What was the example hoping to show?
	int h[] = {56,78};
	int i = 999;
	h[2] = 5;
    cout << i << endl;
    cout << sizeof(h) << endl;
	cout << h[15] << endl;
//6. Are arrays passed by value or by reference?
	cout << h[1] <<endl;
	zero(h,2);
	cout << h[1] << endl;
	
//7. What will the following print?
	//cout << h << endl;

//8. I'm going to skip multidimensional arrays, but what are they?

}

void zero(int ar [], int size)
{
for (int x = 0; x<(sizeof(ar)/sizeof(int)); x++)
	ar[x]=0;
for (int x = 0; x<2; x++)
	ar[x]=0;
}

//check out http://www.cplusplus.com/reference/array/array/
//whats the difference?