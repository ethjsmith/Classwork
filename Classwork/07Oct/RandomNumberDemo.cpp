//Random number demo code in C++
//10-6-2020
//-Dr. G
//tested on : https://www.onlinegdb.com/online_c++_compiler

#include<iostream>
#include<cstdlib>//needed for rand function
#include<ctime>//needed for clock generated seed

using namespace std;

int main()
{

//Review: 
//How are random number useful?
//How are random numbers generated?
//Is there actually such a thing as random numbers on computers?


cout << time(NULL) << endl;

//1. 
//Generate pseduo-random numbers

cout << "Run - no seed" << endl;
for (int i=0; i<8; i++)
	cout << rand()<<endl;

//Run this program twice. What do you notice?
//Do your numbers match my numbers?
//What does this tell you?

//Comment out the above section and run the next section

// this seeds it LULW
srand(56);

cout << "Run - seed of 56" << endl;
for (int i=0; i<8; i++)
	cout << rand()<<endl;
	
//What happens if you run your program twice?
//What can we assume from all of this?





/*


//seed it with the clock and run twice
srand(time(NULL));
	
cout << endl << "Run - clock seed" <<endl;
for (int i=0; i<8; i++)
	cout << rand() <<endl;
*/
}

//1. Create int max random numbers from 1 - 100 (use modulus)
//2. Save the number of occurrences of each number in an int array. 
//3. Output the percentage of occurrences of each random number. 
//4. Try it with the seeds presented above and see how the results differ. 
