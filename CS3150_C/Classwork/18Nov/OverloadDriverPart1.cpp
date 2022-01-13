// Ethan Smith
// C++ (CS3150)
// Complete the demo code assignment
//
//
//Demo code for operator overload in C++

#include <iostream>
#include <math.h>

using namespace std;
	
	//15. Implement the equality and inequality operator for points and lines as homework
	//16. Implement the <> operators for lines based on line length
	//17. Implement any one of the compound assignment operators for homework

//simple Point class 
class Point
{
	private: 
			

	public:
		int x,y;
		Point();
		Point(int, int);
		void showPoint();
		Point operator=(const Point &);
		Point operator+=(const Point &);
		// friend Line l;
		// friend Point operator+(const Point &, const Point &); // set this function ( which isn't really part of the point class kek) as a friend so it can access private variables
		// friend Point operator-(const Point &, const Point &);
		// friend bool operator==(const Point &, const Point &);
		// friend bool operator!=(const Point &, const Point &);

		//Point operator+(const Point &, const Point &);
};

Point::Point():x(0),y(0){}
Point::Point(int x, int y): x(x), y(y){}
void Point::showPoint(){cout << x << " " << y << endl;}
Point Point::operator=(const Point & p2){
	x=p2.x;
	y=p2.y;
	return *this;
}
Point operator+(const Point &p1, const Point &p2){
	Point p3(p1.x+p2.x,p1.y+p2.y);
	return p3;
}
//12. Implement the subtraction overload for homework
Point operator-(const Point &p1, const Point &p2){
	Point p3(p1.x-p2.x,p1.y-p2.y);
	return p3;
}
//15. Implement the equality and inequality operator for points and lines as homework
bool operator==(const Point &p1, const Point &p2) {
	if(p1.x == p2.x && p1.y == p2.y){
		return true;
	}
	return false;
}
bool operator!=(const Point &p1, const Point &p2) {
	if(p1.x == p2.x && p1.y == p2.y){
		return false;
	}
	return true;
}
//17. Implement any one of the compound assignment operators for homework
// lets do += for point, point. it will be a member of point 
Point Point::operator+=(const Point &p){
	x = x + p.x;
	y = y + p.y;
	return *this;
}



//simple line class containing two points
class Line
{
	private: 
		

	public:
		Point p1, p2;
		Line();
		Line(Point, Point);
		void showLine();
		Point getP1();
		double getLength();
		friend bool operator>(const Line &, const Line &);
		friend bool operator<(const Line &, const Line &);
};

Line::Line(Point p1, Point p2):p1(p1),p2(p2){}
Line::Line(){}		// why don't I need to construct the points?
void Line::showLine(){p1.showPoint(); p2.showPoint();}
double Line::getLength(){
	//d = ssqrt(x2-x1)^2 + (y2-y1)^2)
	return sqrt(pow((p2.x-p1.x),2) + pow((p2.y-p1.y),2));
}
//16. Implement the <> operators for lines based on line length
bool operator>(Line &l1,Line &l2){
	if (l1.getLength() > l2.getLength()) {
		return true;
	}
	return false;
}
bool operator<(Line &l1,Line &l2){
	if (l1.getLength() < l2.getLength()) {
		return true;
	}
	return false;
}

int main()
{
	//1. Review the above classes and answer any questions
	
	
	// int y = 2;
	// int x = 3; 
	// cout << x+y;
	//x + y translates to a function  "operator+(x,y);"
	
	// double y = 2.0;
	// double x = 3.0; 
	// cout << x + y; 
	//x + y translates to a function  "operator+(x,y);" but for doubles
	
	//But what about more complex objects?
	
	
	//2. Create a void assignment overload for each class above
	
		//Think about how assignment works p1 = p2; 
		//Function wise this would look like p1.eq(p2);
		//On the left is the calling object and on the right is the object being sent
		
	// we want to use assignment 	
		// implement this in point
	Point p1(1,2);
	Point p2;
	Point p3;
	
	p2 = p1;
	p3 = p1 + p2;
	p1.showPoint();
	p2.showPoint();
	p3.showPoint();	
		
		
	//3. Test the void assignment operators
	//4. Attempt to "chain" (p1 = p2 = p3) and observe the results.
	//5. Why does this fail? How do we fix it?
	//6. What's the difference in the assignment operator and the construtor?
	
	
	//7. Now for something more complicated. I want to be able to say p1 = p2 + p3;
		//How does "replacement work?"
		//Why would an arithmetic expression need two arguments and why does the 
		//assignment only need one?
		
	//8. How many "objects" are involved in an arithmetic expression?
	//9. What is a "friend?"
	//10. Create a friend function for overloading addition on point and line. 
	//11. Test
		//How could we implement this without making the function a "friend?"
		//How could we implement it as a member function?
		
	
	//13. Would compound assignment operators be member functions?
	//14. Would relational operators be member functions?
	
	//18. Next class we'll work on streams, conversion, increment/decrement, and subscript
}