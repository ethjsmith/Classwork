//Demo code for operator overload in C++

#include <iostream>

using namespace std;


//simple Point class 
class Point
{
	private: 
		int x,y;

	public:
		Point();
		Point(int, int);
		void showPoint();
};

Point::Point():x(0),y(0){}
Point::Point(int x, int y): x(x), y(y){}
void Point::showPoint(){cout << x << " " << y << endl;} 


//simple line class containing two points
class Line
{
	private: 
		Point p1, p2;

	public:
		Line();
		Line(Point, Point);
		void showLine();
};

Line::Line(Point p1, Point p2):p1(p1),p2(p2){}
Line::Line(){}		// why don't I need to construct the points?
void Line::showLine(){p1.showPoint(); p2.showPoint();}

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
	//3. Implement a line output stream operator for homework. 
	//4. Create an input stream operator for point. 
	//5. Why did we have to drop the const in this situation?
	//6. Implement a line input stream operator for homework. 
	//7. Let's talk about conversion. Would that be a member of friend?
	//8. We aren't going to implement conversion for this class. I don't think it makes
	//sense in this example, but make sure you read through it. 
	//9. Increment and decrement friend or member?
	//10. Create a pre increment overload
	//11. Create a post increment overload
	//12. What is the functional difference?
	//13. Implement a pre increment overload for line that just increments p2 for homework
	//14. Subscript member or friend?
	//15. What would it return and what would you need to send it?
	//16. Create a subscript operator overload for point
	//17. Implement a subscript operator for line that returns a point for homework
	//18. How else could you setup a subscript operator with line?

	
}