/* 	Written/modified by Ethan Smith
* 	Date: 9/21/2020
*	Assignment: Prime examples
*
*/
#include <iostream>
#include <math.h>
using namespace std;
bool isPrime(int a) {
	int n = 2;
    // if n is greater than a's largest factor then break basically
	while (sqrt(a) >= n) {
		if (a % n == 0) {return false;}
		else  {n++;} 
	}
	return true;
}
void listPrimes(int a) {
    // slower, but more intuitivate solution than the suiv of erasmiansda
    cout << "from 1 to " << a << " here are all the prime numbers:" << endl;
	int n = 2;
	while (n <= a) {
		if (isPrime(n)) {
			cout << n << ", ";
		}
		n++;
	}
    cout << endl;
}
