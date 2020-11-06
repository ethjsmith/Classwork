/*
File IO CPP Demonstration 
10-21-19
Dr. G
https://www.learncpp.com/cpp-tutorial/181-input-and-output-io-streams/
*/

#include <iostream>
#include <iomanip> //io manipulators
#include <sstream> //string streams
#include <fstream> //file io

using namespace std;

int main()
{
	//What is a stream?
	//What are the >> << operators?
	
	// 1. Try this code segment and explore what happens
	// char buf[3];
	// cin >> buf;
    // cout << buf << endl; 

    
    //What happens if you exceed your buffer?
    //Use setw to restrict buffer size.
    
    //2. What is the following code segment doing?
    
    // char ch;
  	// while (cin >> ch)
        // cout << ch;
        
        
    //cin.get will use newlines for separator instead of spaces try it.
        
    //3. What does the following code do?
    
    // char strBuf[11];
    // cin.get(strBuf, 11);
    // cout << strBuf << endl;
    
    
    
    //4. There are other methods that are useful as well
    
    //Keep in mind that a stream is a stream. It can be the command line or a file. 
    //As you'll soon see. 
    //What is the difference between get and getline?
    
    /*
    ignore() discards the first character in the stream.
	ignore(int nCount) discards the first nCount characters.
	peek() allows you to read a character from the stream without removing it from the stream.
	unget() returns the last character read back into the stream so it can be read again by the next call.
	putback(char ch) allows you to put a character of your choice back into the stream to be read by the next call.
	*/
    
    //5. I'm going to skip the output section(18.3). It is mostly going over ways to format output.
    //but this section could be useful for your lab assignment.
    //https://www.learncpp.com/cpp-tutorial/183-output-with-ostream-and-ios/
    
    //6. String streams are buffer variables for strings
    
    // stringstream os;
    // os << "512345 67.89";
	
    // cout << os.str() << "\n";
    // cout << os.str() << "\n";
    // cout << os.str() << "\n";
    
    
    // string s1,s2;
  	// os >> s1;
	// cout << "String s1 : " << s1 << "\n";
   	// os >> s2; 
  	// cout << "String s2 : " << s2 << "\n";
 	// cout << os.str() << "\n";
 	
 	
 	
 	//7. C++ will convert from text into whatever format it is being directed into from a stream
 	/*
 	
 	stringstream os;
    os << "512345 67.89";
    
 	int i1;
 	double d1;
 	
 	os >> i1 >> d1;
 	
 	cout << i1 << " " << d1 << "\n";
 	*/
 	
 	//What happens if you try to run both 6 & 7 and why?
 	//How would you fix that problem?
 	
 	//8. I'm skipping 18.5, but review
 	//https://www.learncpp.com/cpp-tutorial/185-stream-states-and-input-validation/
 	
 	//9. A stream can also be a file
 	
 	
 	// ofstream outf("out.txt"); //out file stream
 	
 	//Always check to make sure the file can be created.
 	//What would be some reasons it would fail?
 	
 	// if (!outf)
 	// {cerr <<"unable to open file for writing!" << endl; exit(1);}
 	
 	// outf  << "Meet me at midnight" << endl;
 	// outf << "by the old oak" << endl;
 	
 	//It's good manners to close a file after it was created. 
 	//This also makes sure the output buffer is flushed.
 	// outf.close();
 	
 	// ifstream inf("out.txt"); //in file stream
 	
 	//What would be some reasons an in file creation would fail?
 	// if (!inf)
 	// {cerr <<"unable to open file for reading!" << endl; exit(1);}
 	
 	// string s1;
 	// inf >> s1;
 	// cout << s1 << endl;
 	
 	// getline(inf,s1);
  	// cout << s1 << endl;
  	
  	//What if you wanted to read in numbers that were written as text?
 	
 	//How about getting the entire file line by line?
 	/*	
 	//while (inf)
 	//{
 	//	getline(inf,s1);
 	//	cout << s1 << endl;
 	//	}

 	inf.close();
 	*/
 	
 	//10. But all files are not text
 	
 	
 	// ofstream outf("out.txt");
 	
 	// if (!outf)
 	// {cerr <<"unable to open file for writing!" << endl; exit(1);}
 	
 	// What does this do?
 	// int x = 123;
 	// double y = 4.0;
 	// string z = "here we go";
 	
 	// outf << x << y << z;
 	
 	// outf.close();
 	
 	
 	//11. First let's look at writing with a buffer
 	/*
 	//ostream& write(const char*, int);
 	//ostream& read(const char*, int);
 	
 	ofstream outf("out.txt");
 	
 	if (!outf)
 	{cerr <<"unable to open file for writing!" << endl; exit(1);}
 	
 	char buff[] = {"A phrase to write\n"};
 	
 	//It's important to note that this writes at the current position of the file pointer
 	outf.write(buff, sizeof(buff));
 	*/
 	
 	
 	// this is the important part, you need a char buffer to deal with low level functionaljtiyl
	
 	unsigned char b ;//= 0xff;

 	ifstream inf("out.txt");
 	
 	if (!inf)
 	{cerr <<"unable to open file for writing!" << endl; exit(1);}
 	
 	while(inf)
 	{
 		inf >> b;
   		std::cout << std::hex << +b << '\n';
   	}
   	
   	inf.close();
   	
	// cool trick: extact multiple hex values , reverse them, and turn them back into the same number... gotta use bitshifting for htat 
	
	
   	
   	//Review lab assignment
   	
   	//ICE
   	//12. Display a file just as hex characters
   	//13. Copy a file using just the hex values
   	//14. Change every space in a text file to an _
   	//15. 
   	
}

