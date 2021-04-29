/* 	Written/modified by Ethan Smith
* 	Date: 9/21/2020
*	Assignment: Prime examples
*
*/
#include <iostream>
#include "pfuncs.h"

using namespace std;
int main() {
    
   // tests here... 
   
cout << "10 IS NOT PRIME and should return 0: Return:" << isPrime(10) << endl;
cout << "3 is PRIME and should return 1: Return:" << isPrime(3) << endl;
cout << "10 IS NOT PRIME and should return 0: Return:" << isPrime(20) << endl;
cout << "103 is PRIME and should return 1: Return: " << isPrime(103) << endl;
cout << "Listprimes (20)  should print out "<<endl << "2, 3, 5, 7, 11, 13, 17, 19" << endl;
listPrimes(20);

cout << "listprimes(103) should print out "<<endl <<"2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103" << endl;
listPrimes(103);
}