//for input and output
#include <iostream>
#include <fstream>

//for vector creation
#include <vector>

//for random number generation
#include <stdlib.h> 
#include <time.h>       


using namespace std;

class Quotes
{
    private:
    vector <string> quotes;
    string tempS;
    int * numQuotes; 
    
    public: 
   
   //Constructors and Destructors
   Quotes(string FileName){loadQuotes(FileName);}
   ~Quotes(){delete numQuotes;}
   Quotes(const Quotes& q1)
   {
       quotes = q1.quotes;
       tempS = q1.tempS;
       numQuotes = new int; 
       *numQuotes = *(q1.numQuotes);
   }
   
   //Methods
   void loadQuotes(string);
   string getQuote(); 
   
   friend void printVec(Quotes*);
};

void printVec(Quotes* q)
{
	 for (string temp: q->quotes)
        cout << temp << endl;
    cout << endl;
}

int main()
{
    
    Quotes q1("Quotes.txt");
    cout << q1.getQuote() << endl;
    //printVec(&q1);
    
    return 0;
}

 void Quotes::loadQuotes(string FileName)
    {
        ifstream inf(FileName); 
        numQuotes = new int; 
    
        if(!inf){cerr <<"unable to open file for reading!" << endl; exit(1);}
    
        while (inf)
 	    {
 	        getline(inf,tempS);
 		    quotes.push_back(tempS);
 	    }
    
        *numQuotes = quotes.size();
    
    inf.close();
        
    }
    
    string Quotes::getQuote()
    {
        srand(time(NULL));
        return(quotes[rand()%quotes.size()]);
    }


