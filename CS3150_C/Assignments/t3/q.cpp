// Ethan Smith
// Test 3 
// C++ 3150
// 11/23/20

/*All the declarations you should need*/
//for input and output
#include <iostream>
#include <fstream>

//for vector creation
#include <vector>

//for random number generation
#include <stdlib.h>
#include <time.h>       


using namespace std;

/*
Task 1: construct the class object as described within the comments 40 Points
*/

/*Create a class called Quotes*/
    
    /*
    Within Quotes create private variables:
    string vector named "quotes"
    string tempS
    a pointer to an int named "numQuotes"
    */
class Quotes {
	private: // private variables
		vector<string> quotes;
		string tempS;
		int* numQuotes;
	public: // constructors and destructors
		Quotes(string);
		~Quotes();
		Quotes(Quotes&);
		// methods 
		void loadQuotes(string);
		string getQuote();
		friend void printVec(Quotes*);
	
};
Quotes::Quotes(string s){ // default constructor, runs the load quotes method
	loadQuotes(s);
}
Quotes::Quotes(Quotes& q){ // copy constructor, just sets everything 
	quotes = q.quotes;
	tempS = q.tempS;
	numQuotes = q.numQuotes;
}
Quotes::~Quotes(){
	delete numQuotes; // todo fix // nvm this works? 
}
    /*
    Within Quotes create the following Constructors/Destructors
    An argument constructor that accepts a string and calls load Quotes
    A destructor that will unallocate anything dynamically created
    A copy constructor
    */
 
   /*
   Declare the following method prototypes
   a loadQuote method that accepts a string and returns nothing
   a getQuote method that returns a string and accepts nothing
   */




/*
Task 2: Fix it so this method can access quotes without making it a member function
within quotes. 15 Points

At the moment it is pass by value. Change it so that it will accept a pointer to
a quote instead. You'll have to fix main as well. 15 Points
*/


void printVec(Quotes* q) // make this a friend to fix it 
// to fix the other thing, change it to a pointer,
// and deferefference ->  the q.quote line below
{
     for (string temp: q->quotes)
        cout << temp << endl;
    cout << endl;
}


int main()
{
    Quotes q1("Quotes.txt");
    cout << "Getting a random quote : " + q1.getQuote() << endl;
    cout << endl << endl << "Printing all quotes.";
    printVec(&q1);
    
    return 0;
}


/*
Task 3 : Complete the following method by following the comments 30 Points
*/
 void Quotes::loadQuotes(string FileName)
    {
        
        numQuotes = new int;
        
        /*
        Create an ifstream object named inf that and point it to the sent filename
        Do the appropriate check to see if the file was there
        */
        
		ifstream inf(FileName, ifstream::binary);
		if (!inf) {// if the infile is null then it broke, so  exit
            cerr << "unable to open file for reading!" << endl;
            exit(1);
        }
		
        while (inf)
         {
             //inf >> tempS;
			 getline(inf,tempS); // get a line
			 quotes.push_back(tempS); // add that line to the vector
         }
    
        *numQuotes = quotes.size();
    
    inf.close();
        
    }
    
    string Quotes::getQuote() 
    {
        srand(time(NULL));
        return(quotes[rand()%quotes.size()]);
    }
