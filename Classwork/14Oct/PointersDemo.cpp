// Pointers and Reference

//* - dereference operator : used to declare a pointer and access the memory pointed to by the pointer
//& - reference operator : used to indicate you want the address of a variable not the variable itself
//-> - member selection : used to refer to struct or class members


//1. What happens when a variable is declared?
//Where is the memory reserved?
//How does it know how much space to reserver?


#include <iostream>
using namespace std;

//for demo
int& max(int& k, int& l)
{return (k > l ? k : l);}
/*
//for demo
int swap(int x, int y){
	int temp = x;
	x=y;
	y=temp;
	return 1;
}


//swap that uses reference varaibles
int swap(int x, int y){
	int temp = x;
	x=y;
	y=temp;
}
*/
//swap that uses pointers
void swap(int *x, int *y){
	int temp = *x;
	*x=*y;
	*y=temp;
}


int main()
{
	int a;
	
	//2. explain each of the following
	cout << a << endl;
	a = 111;
	cout << "a = " << a << endl;
	cout << "&a = " <<&a << endl;
	
	//3. declare another int and check the address
	int b = 222;
	cout << "&b = " << &b << endl;

	//4. and again
	
	int c = 222;
	cout << "&c = " <<&c << endl;

	//5. declare a reference variable
	
	int d = 44; 
	int& e = d;
	
	cout << "d = " << d << endl;
	cout << "e = " << e << endl;
	++d;
	cout << "d = " << d << endl;
	cout << "e = " << e << endl;
	
	//what's wrong with saying int& = 44?
	
	cout << "&d = " << &d << endl;
	cout << "&e = " << &e << endl;
	
	//So type& x reads as what?
	//and &variable reads as what?
	
	swap(a,b);
	cout << a << " " << b << endl;
	//why doesn't the above code actually change anything?
	//use reference variables to fix that
	//tip: don't change the swap call
	
	//6. A pointer is a variable that holds an address
	
	int f = 333;
	int* g=&f; //store the address of f in g
	
	cout << " f = " << f << " &f = " << &f << " &g = " << &g << endl;
	//dereferencing g gives us ....
	cout << "*g = " << *g <<endl; 
	cout << " g = " << g << endl;
	
	int ** h = &g; 
	cout << "h = " << h << " &h = " << &h << " *h = "<< *h <<endl;
	
	//Do swap again, but this time use pointers
	//tip: this time you will have to change the swap call
	
	//what is an lvalue and why is it important?
	//it is something that can be on the left side of an =
	int i = 55;
	int j = 66; 

	cout << max(i, j) << endl;
	max(i,j) = 99;
	
	cout << j << endl;
	
	//using pointers to transverse an array
	int k[] = {0,11,22,33,44,55,66,77,88,99};
	int* pk =k;
	//why don't we have to say &k?
	//An array name is a constant pointer to the first element in an array
	
	cout << "*pk = " << *pk << endl;
	pk++;
	cout << "*pk = " << *pk << endl;
	//pros and cons to this?
	
	//Why is this dangerous?
	int l = 333;
	int* pl=&l;
	cout << "*pl = " << *pl << endl;
	pl++;
	cout << "*pl = " << *pl << endl;
	
	//The new operator with pointers
	
	float* m; //this is legal but the memory isn't allocated to anything
	
	//cout << "the contents of m are " << *m;
	
	float n = 3.14;
	m = &n; 
	cout << "the contents of m are " << *m <<endl;
	*m = 7.894;
	cout << "n now holds " << n << endl;
	
	float* o;
	o = new float;
	
	//at this point there's still nothing predictable in it
	cout << "o currently " << *o << endl;
	
	*o = 7.894;
	
	//Whats the difference?
	//well remember this
	cout << "o is actually this " << o << endl;
	
	//although you can initialize at the same time
	double ee = 3.14159; 
	double* dd= &ee;
	cout << "d holds " << *dd << endl;
	
	//what does it mean if a pointer == 0. Not the content but the pointer
	
	delete dd; 
	
	//cout << "dd after deletion " << *dd << endl;
	
	//talk about this
	float ff[20];
	float* const gg = new float[20];
	
	//advantages create and destroy, size can be adjusted during execution
	
	//when you pass a pointer you pass it by reference double*&
	//review example 7.16
	//review you can have arrays of pointers and pointers to arrays
	//pointers to pointers
	//pointers to functions
	//const pointers and pointers to constants
	
}