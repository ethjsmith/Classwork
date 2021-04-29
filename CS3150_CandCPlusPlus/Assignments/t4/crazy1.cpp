/* (modified by ) Ethan Smith
 * C++ Final Practical
 * obscure file
 * 12/16/20
 */


#include <iostream>

using namespace std;

int main ()
{
int x = 10;
int y = 010;
int z = 0x10;

cout << "x + y = " << x+y << endl; // This line is appending x and y, so 10 + 010 = 10010 which is the binary representation for 18
cout << "z + 1 = " << z + 1 << endl; // the Z is a hexidecimal number which equals 16, so adding 1 to 16 gives you 17
cout << "++x ++y ++z " << ++x << " " << ++y << " " << ++z << endl;
// this line ++x treats x as an int so its 11,
//++y treats y as octal, so it = ++8 or 9
// z is treated as hex and so it does the same thing as the previous line, by adding one.
}
