
#include <iostream>

using namespace std;

int main()
{
	// these were from the ICE... they won't compile because many of them are illegal, and others of them don't have declared variables, or use the same variables as something else ...
char* const x = new char[10];
float& a = b;
char *** w = &y;
float(*pf)(float);
int& y = g++;
const int* const t = 7k;
int* j = 87;
*n = 897;
float **q =5;
int&x=99;
int* x[99];
float y* = &m;
double* y = 876;
++(*x);
int k* = 1;
char a =b;
const int * x = y;
double x[7] = 4;
int x[] = 9;
string *y = &x;
	
}