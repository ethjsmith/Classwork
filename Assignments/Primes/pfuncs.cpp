/* 	Written/modified by Ethan Smith
* 	Date: 9/21/2020
*	Assignment: Prime examples
*
*/
#include <iostream>
using namespace std;
bool isPrime(int a) {
	int n = 2;
	while ((a/2) > n) {
		if (a % n == 0) {return false;}
		else  {n++;} 
	}
	return true;
}
void listPrimes(int a) {
	int n = 1;
	while (n < a) {
		if (isPrime(n)) {
			cout << n << " is prime" << endl;
		}
		n++;
	}
}
