/*
BMP Checker
11-8-20
Dr. G
https://www.learncpp.com/cpp-tutorial/181-input-and-output-io-streams/
*/

#include <iostream>
#include <iomanip> //io manipulators
#include <sstream> //string streams
#include <fstream> //file io

//to make the code more readable I'm going to declare a byte is a char
#define byte char

using namespace std;

//accept an input and an output filename
int main(int argc, char* argv[])
{
	if (argc ==3) //why three
	{
		//Setup your first to bytes for the header check. 42 and 4d
		
		 byte h1 = 0x42;
		 byte h2 = 0x4d;
		
		
		//Create two bytes for your first two inputs
		
		 byte b1 = 0xff;
		 byte b2 = 0xff;
		
		
		//setup and create an input file stream
		//set it to binary mode
		
		ifstream inf(argv[1], ifstream::binary);
		if (!inf){
			cerr <<"unable to open file for reading!" << endl;
			exit(1);
		}
		
		//Read in first two bytes
		inf >> b1 >> b2;
		
		//Check the header
		
		if (b1 == h1 && b2 == h2) {
			cout << "Good header" << endl;
		}
		else
		{
			cout << "Header check failed" << endl;
			return 0;
		}
		// we want to use a buffer because it's more efficent for file IO I guess 
		
		
		
		
		
		//Move the pointer back to the beginning of the file
		//Look up the seek comand
		//inf
		
		//load in the rest of the file
		cout << "loading file" << endl;
		inf.seekg(0);
		
		//setting up a buffer 
		inf.seekg(0,ios::end) ; //move pointer to the end
		int length = (inf.tellg()); //get pointer position
		
		
		cout << "File is :" << length << " bytes in length" << endl;
		
		//inf ; //move back to the beginning	
		inf.seekg(0);//reset file pointer to start of file. 


		byte* buffer = new byte[length];//prepare a buffer
		
		// could do 
		// for (int x=0;x<length;x++){
			// char tmp;
			// inf >> temp;
			// buffer[x] = temp;
		// } // This next thing does the same thing, but more effeciently
		inf.read(buffer,length) ;//load the buffer
		cout << std::hex << buffer[5] << std::hex << buffer[4] << std::hex << buffer[3] << std::hex << buffer[2] << endl;
		//create an output stream
		
		ofstream outf(argv[2], ofstream::binary);
		if (!outf){cerr <<"unable to open file for writing!" << endl; exit(1);}
		
		
		//write out the file for testing purposes
		
		//Method 1
		//outf.write(buffer, length);
		
		//Method2
		
		for (int x = 0; x<= length; x++)
			outf << buffer[x];
		
		
		//clean up
		inf.close();
		outf.close();
   	}
	else cout << "You must run this program with an input filename and an output filename. " << endl;
   	
}

//Things I'm leaving to your
//Convert the hex values into int values
//Combine multiple hex values to make a single int value


//ICE
//Submit completed working code
//Print out the FILESIZE in the correct order

