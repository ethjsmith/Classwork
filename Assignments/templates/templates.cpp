/*
*   Ethan Smtih
*   Templates assignment
*   CSIS 3150 ( C++)
*   12/11/2020
*/


#include <iostream>

using namespace std;

template <typename T> // part 3 , comparason
bool compare(T a, T b) {
  if (a == b) {
    return true;
  }
  return false;
}


template <typename T> // part 1, generic sum function
T getSum(T x[], int size){
  T rtotal=0;
  for (int i=0;i<size;i++){
    rtotal += x[i];
  }
  return rtotal;
}
template <> // overrides the char template, so if it's chars it does this
char getSum<char>(char x[], int size) {
    return 'Z';
}
template <typename T> // part 2  fraction class
class Fraction {
private:
  T top;
  T bot;
public:
  T getTop(){
    return top;
  }
  T getBot(){
    return bot;
  }
  void setBot(T b){
    bot = b;
  }
  void setTop(T t){
    top = t;
  }
  void print(){
    cout << top << "/" << bot << endl;
  }
  friend bool operator==(Fraction a,Fraction b) {// part 3 implement a way to compare fractions
    if (a.getTop() == b.getTop() and a.getBot() == b.getBot()){
      return true;
    }
    return false;
  }
};

int main() {
  // testing for part 1
int a1[3] = {1,2,3};
double a2[3] = {1.1,2.2,3.3};
char a3[3] = {'a','b','c'};
cout << getSum(a1,3)<< endl;
cout << getSum(a2,3) << endl;
cout << getSum(a3,3) << endl;
// testing part2

Fraction <int>a,d;
Fraction <double>b;
Fraction <string>c;
a.setTop(1);
a.setBot(2);

d.setTop(5);
d.setBot(0); // heuheuheu illegal fraction :)

b.setTop(3.2);
b.setBot(6.6);

c.setTop("a");
c.setBot("b");

a.print();
b.print();
c.print();


//testing part 3
cout << compare(a,a) << endl;
cout << compare (a,d) << endl;// comparing fractions
cout << compare (1,3) << endl; // compare ints
cout << compare ( 4.2, 4.2) << endl; // compare doubles


}
