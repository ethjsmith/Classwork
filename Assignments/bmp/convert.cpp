// Ethan Smith
// bmp conversion lab
// 11/18/2020
// CS3150(?)
// Don't forget to like and subscribe

#include <iostream>
#include <iomanip> //io manipulators
#include <sstream> //string streams
#include <fstream> //file io
#include <algorithm>

using namespace std;

void lightness(unsigned char *b, int length) {
    for (int i=36; i < length; i += 3) {
        //take three numbers for the three colors
        int v1=b[i];
        int v2=b[i + 1];
        int v3=b[i + 2];
        unsigned char ncolor=(max(max(v1, v2), v3) + min(min(v3, v2), v1)) / 2; //lightness formula
        // reassign those colors to the same each, or grey
        b[i]=ncolor;
        b[i + 1]=ncolor;
        b[i + 2]=ncolor;
    }
}
void average(unsigned char *b, int length) {
    for (int i=36; i < length; i += 3) {
        // same as before but different formula
        int v1=b[i];
        int v2=b[i + 1];
        int v3=b[i + 2];
        unsigned char ncolor=(v3 + v1 + v2) / 3;
        b[i]=ncolor;
        b[i + 1]=ncolor;
        b[i + 2]=ncolor;
    }
}
void luminosity(unsigned char *b, int length) {
    for (int i=36; i < length; i += 3) {
        int v1=b[i];
        int v2=b[i + 1];
        int v3=b[i + 2];
        // final formula for different shades of grey :^)
        unsigned char ncolor=(.21 * v3) + (.72 * v2) + (.07 * v1);
        b[i]=ncolor;
        b[i + 1]=ncolor;
        b[i + 2]=ncolor;
    }
}

int main(int argc, char *argv[]) {
    if (argc==3) {
        char h1=0x42;
        char h2=0x4d;
        char b1=0xff;
        char b2=0xff;

        ifstream inf(argv[2], ifstream::binary);// read in provided filename
        if (!inf) {
            cerr << "unable to open file for reading!" << endl;
            exit(1);
        }

        inf >> b1 >> b2;
        // read in new values for the header and check them
        // this part was done in class
        if (b1==h1 && b2==h2) {
            cout << "Good header" << endl;
        }
        else {
            cout << "Header check failed" << endl;
            return 0;
        }
        inf.seekg(0, ios::beg);
        inf.seekg(0, ios::end);
        int length=inf.tellg();
        cout << "File is " << length << " bytes in length" << endl;
        // file length. this was a requirement, but was also done in class...
        inf.seekg(0, ios::beg);
        unsigned char *buffer=new unsigned char[length];
        inf.read((char *)buffer, length);


        string fname=(string)argv[2];
        fname.erase(fname.length() - 4);
        // select the algorithm to use based on which number was entered at runtime.
        if (atoi(argv[1])==1) {
            lightness(buffer, length);
            fname=fname + "BW_lighness.bmp";
        }
        else if (atoi(argv[1])==2) {
            average(buffer, length);
            fname=fname + "BW_average.bmp";
        }
        else if (atoi(argv[1])==3) {
            luminosity(buffer, length);
            fname=fname + "BW_luminosity.bmp";
        }
        else { // if the number isn't able to be read or is too big or whatever, reprompt for new number
            cout << "Incorrect selection input" << endl;
            cout << "Enter 1 for lightness" << endl;
            cout << "Enter 2 for average" << endl;
            cout << "Enter 3 for luminosity" << endl;
            inf.close();
            //outf.close();
            exit(1);
        }
        ofstream outf(fname, ofstream::binary);
        if (!outf) { // check if the file is valid/writable
            cerr << "unable to open file for writing!" << endl;
            exit(1);
        }// write the new file
        outf.write((char *)buffer, length);
        outf.close();
        inf.close();
    }
    else {
        cout << "You must run this program with an algorithm choice (1-3), and an input filename" << endl;
    }
}
