//Template Demonstration
//Dr. G
//November 24th, 2018
//Updated December 3rd, 2020

#include <iostream>

using namespace std;

//A template is a way to autogenerate code when you want to create something that is type
//independent.

/* 			Function Templates			*/

//Here is a standard function to return the max of two int values
// int GetMax(int x, int y)
// {return (x > y) ? x : y;}

//Based on what we've learned so far, what would you do if you wanted to create a function
//with the same name, but have it accept doubles? What is this called?

//1. Comment out the above functions
//2. Replace with a template function

template <typename T, typename T2> // mixed mode
T GetMax(T x, T2 y){
  return (x > y) ? x : y;
}

//Java has a similar feature called: _______im not answering this inline comment_____________

//3. Compile executables using both techniques and compare file sizes.
//What could the results indicate?

/*		Class Templates		*/

//5. We can also autogenerate class templates. Create a class point that will take ints or
//doubles.
template <typename T>
class Point {
  private:
    T x;
    T y;
  public:
    Point(T x, T y): x(x), y(y) {}
    T getX();
    void showPoint(){
      cout << x << "," << y << endl;
    }

    friend bool operator>(const Point &p1 const Point &p2){
      return (p1.x>p2.x && p1.y>p2.y);
    }
    friend ostream& operator<<(ostream& ost, const Point& p){
      return ost << p.x  << "" << p.y;
    }
};
// void Point::showPoint(){
//   cout << x << ":" << y << endl;
// }
template <typename T>
T Point<T>::getX(){
  return x;
}




/*			Template Specialization  	*/

//What if we want the template to act the same except if we send a specific type?

//9. Create a function that will increase any value sent by 1 unless it is a char. When it
//it is a char change it to upper case instead.

//This works the same with classes. Just remember to replace the 'T' with the actual type

//10. Thinking question. Templates are compiled when required. What restriction does this
//have on multi-file compilations?

int main()
{
  cout << GetMax(9.3,6.4) << endl;

  Point<int> p1(4,5);
  Point<int> p3 (7,8);
  Point<double> p2(2.3,4.5);

  p1.showPoint();
  p2.showPoint();

  cout << GetMax(p1, p3) << endl; // do some overloading to fix this kek


}

  //4.
  //You can also explicitly let the compiler know the type, but it can figure it out.
