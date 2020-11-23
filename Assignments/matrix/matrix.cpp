// 	Ethan Smith
//	CS-3150 (C++)
//	Matrix overload
//	11/22/20

#include <iostream>

using namespace std;
// Define a Matrix class to represent 3x3 integer matrices. Implement operations:
// addition, subtraction, multiplication using operator overloading.
// Implement increment/decrement operators which will increment/decrement each element of the matrix by 1. Just implement the prefix not postfix.
// Also overload  the << and >> operators to display and read the matrix to/from the user.
class Matrix;

// represents a 3x3 matrix of ints
class Matrix{
// add , sub, mult, increment, decrement, << >>
  private:
    int a1,a2,a3,b1,b2,b3,c1,c2,c3;
  public:
    Matrix();
    Matrix(int,int,int,int,int,int,int,int,int); // kek

    friend Matrix operator+(Matrix&, Matrix&);
    friend Matrix operator-(Matrix&, Matrix&);
    friend Matrix operator*(Matrix&, Matrix&);
    friend Matrix operator/(Matrix&, Matrix&);

    Matrix operator+=();
    Matrix operator-=();

    friend ostream& operator<<(ostream&,Matrix&);
    friend istream& operator>>(istream&,Matrix&);

};
Matrix(){ // sure I could make a nested array... but I already did it this way 
  a1=0;
  a2=0;
  a3=0;
  b1=0;
  b2=0;
  b3=0;
  c1=0;
  c2=0;
  c3=0;
}
Matrix(int x,int x2,int x3,int x4,int x5,int x6,int x7,int x8,int x9){
  a1=x;
  a2=x2;
  a3=x3;
  b1=x4;
  b2=x5;
  b3=x6;
  c1=x7;
  c2=x8;
  c3=x9;
}
Matrix operator+(Matrix& m1, Matrix& m2){
  Matrix n(m1.a1+m2.a1,m1.a2+m2.a2,m1.a3+m2.a3,m1.b1+m2.b1,m1.b2+m2.b2,m1.b3+m2.b3,m1.c1+m2.c1,m1.c2+m2.c2,m1.c3+m2.c3)
  return n; // this is aweful... now watch me do it 3 more times
}
Matrix operator-(Matrix& m1, Matrix& m2){
  Matrix n(m1.a1-m2.a1,m1.a2-m2.a2,m1.a3-m2.a3,m1.b1-m2.b1,m1.b2-m2.b2,m1.b3-m2.b3,m1.c1-m2.c1,m1.c2-m2.c2,m1.c3-m2.c3)
  return n;
}
Matrix operator*(Matrix& m1, Matrix& m2){
  Matrix n(m1.a1*m2.a1,m1.a2*m2.a2,m1.a3*m2.a3,m1.b1*m2.b1,m1.b2*m2.b2,m1.b3*m2.b3,m1.c1*m2.c1,m1.c2*m2.c2,m1.c3*m2.c3)
  return n;
}
Matrix operator/(Matrix& m1, Matrix& m2){
  Matrix n(m1.a1/m2.a1,m1.a2/m2.a2,m1.a3/m2.a3,m1.b1/m2.b1,m1.b2/m2.b2,m1.b3/m2.b3,m1.c1/m2.c1,m1.c2/m2.c2,m1.c3/m2.c3)
  return n;
}

Matrix Matrix::operator+=(){
  a1 = a1 + 1;
  a2 = a2 + 1;
  a3 = a3 + 1;
  b1 = b1 + 1;
  b2 = b2 + 1;
  b3 = b3 + 1;
  c1 = c1 + 1;
  c2 = c2 + 1;
  c3 = c3 + 1;
}
Matrix Matrix::operator-=(){
  a1 = a1 - 1;
  a2 = a2 - 1;
  a3 = a3 - 1;
  b1 = b1 - 1;
  b2 = b2 - 1;
  b3 = b3 - 1;
  c1 = c1 - 1;
  c2 = c2 - 1;
  c3 = c3 - 1;
}
ostream& operator<<(ostream&,Matrix&){

}
istream& operator>>(istream&,Matrix&){

}



// Sample output:
// Enter a 3x3 integer matrix:
//  2 3 4
//  0 9 -1
//  4 5 -3
// Enter a 3x3 integer matrix:
// 1 0 0
// 0 1 0
// 0 0 1
// ==========================================
// You entered:
// Matrix m:
//  2 3 4
//  0 9 -1
//  4 5 -3
// Matrix n:
//  1 0 0
//  0 1 0
//  0 0 1
// ==========================================
// Matrix addition:
//  3 3 4
//  0 10 -1
//  4 5 -2
// Matrix subtraction:
//  1 3 4
//  0 8 -1
//  4 5 -4
// Matrix multiplication: p = m * n:
//  2 3 4
//  0 9 -1
//  4 5 -3
// ++p:
//  3 4 5
//  1 10 0
//  5 6 -2
// Operator overloads 70 at 10 ea
// Code Quality 20
// Class Creation 10
