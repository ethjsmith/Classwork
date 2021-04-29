#include <iostream>

using namespace std;

    struct Candy {
		string name;
		double weight;
	};
	struct CandyBag{
		Candy* cArray;
		double maxWeight;
	};
bool checkWeight(CandyBag *b1, int num)
{
    double total = 0;
    
    for (int x = 0; x<=num; x++)
        {
			total += b1->cArray[x].weight;
        }
    if (total > b1->maxWeight){
		return true;
	}
	return false;
    //(total > ??? ) ? return true : return false;
}


	// bool checkWeight(CandyBag *c) {
		// double m = 0;
		// for ( int i =0;i<3;i++){
			// m += c.cArray[i].weight;
		// }
		// if (m > c.maxWeight){
			// return True;
		// }
		// return False;
	// }
int main(int argc, char* argv[])
{
    //PART 1 the command line arguments
    //10 points
    
    //1. If the user entered two command line arguments treat them as ints and print
    //the result of the two added together 10 points
    if (argc >= 3) {
		cout << atoi(argv[1]) + atoi(argv[2]) << endl;
	}
	
    //if (argc == ?)
        //cout <<  +  << endl;
    
    //Part 2 pointer and reference variable basics
    //40 points
    
    int a = 1;
    int b = 2;
    int* c = &a;
    int* d = &b;
    int* e = d;
    
    /*
    2. Change 'c' to make it a pointer pointing to the same memory location
    as 'a' then change the following line to increment that space - 5 points
    */
    
    (*c)++;
    cout << "This should print 2 : " <<  a << endl << endl;
    
    /*
    3. Change 'd' to be a pointer to 'b'
    Uncomment and fix the following two print statements - 10 pts
    */
    
    //These two statements should print the same memory address
    cout << "This should print the memory location of b : " << &b << endl;
    cout << "This should print the contents d : " << d << endl << endl;
    
    //4. Change e to be a pointer to d - 10 pts
    cout << "This should print the contents of b using e : " << *e << endl;
    int* f = new int[5];
	int len = 5;
	for (int i=0;i<=5;i++){
		f[i]=i+1;
	}
	//int* f[5] = {1,2,3,4,5};
    
    //5. Change f to a dynamically created array - 10 pts
    //6. Declare a pointer g and use it to print out all the values in f - 10 pts
    
    int* g = f;
	while (g != f+len){
		cout << *g << endl;
		g++;
	}
    
    //PART 2 Trick or Treat
    //50 points
    
    /*
    1. Create a Candy and CandyBag structure.
    Candy has a string name and a double weight
    Candy bag has a pointer to Candy that you can turn into an array and a
    max weight.
    
    The order you create the structs is important.
    
    10 points
    */

    /*
    Create three different candies
    Create a candy bag
    
    Initialize its candy bag to hold three candies and place the three candies in it
    Add those three candies to the candy bag
    20 points
    */
    //Candy c1 = 
    Candy c1, c2,c3;
    c1.name = "twix";
	c1.weight = 1.0;
	c2.name = "cardboard";
	c2.weight = 1.2;
	c3.name = "jolly ranccher";
	c3.weight = 0.9;
	
	CandyBag cb1;
     
    /* oh look, you already made them... maybe I should read before I  type
    name = "snickers";
    weight = 1.8;
    name = "skittles";
    weight = 2.4;
    name= "dots";
    weight = 1.2;
    */
     
     
    cb1.maxWeight = 10;
    cb1.cArray = new Candy[3];
    cb1.cArray[0] = c1;
    cb1.cArray[1] = c2;
    cb1.cArray[2] = c3;
    
     
    /*
    Create a boolean function that will accept a pointer to a candy bag and
    return true if the candy bag is overweight and false if it is not.
    
    Check your candy bag weight and print the result.
    20 points
    */

    /*
    if (checkWeight())
            cout << "Overweight";
        else
                cout << "Not Overweight";
            */
 }
