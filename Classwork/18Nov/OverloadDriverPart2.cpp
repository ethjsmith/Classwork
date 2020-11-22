// 	Ethan Smith
//	CS-3150 (C++)
//	Complete the overloads part 2 assignment
//	11/22/20




//Demo code for operator overload in C++

#include <iostream>

using namespace std;


//simple Point class
class Point;
class Line;

class Point
{
	private:
		int x,y;

	public:
		Point();
		Point(int, int);
		void showPoint();
		Point operator++();
		Point operator++(int);
		int getx();
		int gety();
		void setx(int);
		void sety(int);
		// subscript [0] = x [1] = y
		int& operator[](int);

		friend ostream& operator<<(ostream&, Point&);
		friend istream& operator>>(istream&, Point&);
		friend ostream& operator<<(ostream&, Line&);
		friend istream& operator>>(istream&, Line&);
};
class Line
{
	private:
		Point p1, p2;

	public:
		Line();
		Line(Point, Point);
		void showLine();
		friend ostream& operator<<(ostream&, Line&);
		friend istream& operator>>(istream&, Line&);
		Line operator++();
		Point operator[](int);
};



int Point::getx(){
	return x;
}
int Point::gety(){
	return y;
}
void Point::setx(int t){
	x = t;
}
void Point::sety(int t){
	y = t;
}

Point::Point():x(0),y(0){}
Point::Point(int x, int y): x(x), y(y){}

void Point::showPoint(){cout << x << " " << y << endl;}
ostream& operator<<(ostream& ostr, Point& p) {
	// cout << p.x << ", " << p.y << endl;
	return ostr << p.x << ", " << p.y;
}
istream& operator>>(istream& istr, Point& p){
	cout << "x=" ;
	istr >> p.x;
	cout << "y=";
	istr >> p.y;

	return istr;
}
Point Point::operator++(){
	x+=1;
	y+=1;
	return *this;
}
Point Point::operator++(int){
	Point tmp = *this;
	x+=1;
	y+=1;
	return tmp;
}
int& Point::operator[](int i){
	if (i == 0) {
		return x;
	}
	else {
		return y; // LOL what
	}
}

//simple line class containing two points

//3. Implement a line output stream operator for homework.
//6. Implement a line input stream operator for homework.
//13. Implement a pre increment overload for line that just increments p2 for homework


ostream& operator<<(ostream& o, Line& l){
		return o << l.p1.getx() << ", " << l.p1.gety() << " to " << l.p2.getx() << ", " << l.p2.gety();
}
istream& operator>>(istream& i, Line& l){

		cout << "Point 1:";
		cout << "x = ";
		i >> l.p1.x;
		cout << "y = ";
		i >> l.p1.y;
		cout << "point 2:";
		cout << "x = ";
		i >> l.p2.x;
		cout << "y = ";
		i >> l.p2.y;
		return i;

}
Line Line::operator++(){
	++p1;
	++p2;
	return *this;
}
Line::Line(Point p1, Point p2):p1(p1),p2(p2){}
Line::Line(){}		// why don't I need to construct the points?
void Line::showLine(){p1.showPoint(); p2.showPoint();}
Point Line::operator[](int s){
    if(not s) {
        return p1;
    }else{
        return p2;
    }
}
int main()
{
	//PART 1
	//1. Review the above classes and answer any questions
	//2. Create a void assignment overload for each class above
	//3. Test the void assignment operators
	//4. Attempt to "chain" and observe the results
	//5. Why does this fail?
	//6. What's the difference in the assignment operator and the construtor?
	//7. Now for something more complicated. Why would an arithmetic expression need two
	//arguments and why does the assignment only need one?
	//8. How many "objects" are involved in an arithmetic expression?
	//9. What is a "friend?"
	//10. Create a friend function for overloading addition on point and line
	//11. Test
	//12. Implement the subtraction overload for homework
	//13. Would compound assignment operators be member functions?
	//14. Would relational operators be member functions?
	//15. Implement the equality and inequality operator for points and lines as homework
	//16. Implement the <> operators for lines based on line length
	//17. Implement any one of the compound assignment operators for homework
	//18. Next class we'll work on streams, conversion, increment/decrement, and subscript


	//PART 2
	//1. Member function or friend function?
	//2. Create a output operator overload for point.




	Point p1(3,6);
	Point p2(1,1);
	cout << p1 << endl;

	// Point p2;
	// cin >> p2;

	// cout << p2 << endl;

	//4. Create an input stream operator for point.
	//5. Why did we have to drop the const in this situation?

	//7. Let's talk about conversion. Would that be a member of friend?

	// skipped ? LOL but you can overload conversion (int) x;

	//8. We aren't going to implement conversion for this class. I don't think it makes
	//sense in this example, but make sure you read through it.
	//9. Increment and decrement friend or member?






	//10. Create a pre increment overload

	cout << p1 << endl;
	++p1;
	cout << p1 << endl;
	//11. Create a post increment overload
	cout << p1 << endl;
	p1++;
	cout << p1 << endl;

	//12. What is the functional difference?

	//14. Subscript member or friend?

		// kerblam
	cout << p1[0] << " and " << p1[1] << " and LOL " << p1[2] << endl;
	//15. What would it return and what would you need to send it?
	//16. Create a subscript operator overload for point
	//17. Implement a subscript operator for line that returns a point for homework


	//18. How else could you setup a subscript operator with line?
	cout << "now the lines" << endl;
	Line l1;
	Line l2(p1,p2);

	cin >> l1;
	cout << l1 << endl;

	cout << l2 << endl;;
	++l2;
	cout << l2 << endl;

}
