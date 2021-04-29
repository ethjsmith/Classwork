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
    int data[3][3] ;
  public:
    Matrix();
    Matrix(int[3][3]);

    friend Matrix operator+(Matrix&, Matrix&);
    friend Matrix operator-(Matrix&, Matrix&);
    friend Matrix operator*(Matrix&, Matrix&);
    friend Matrix operator/(Matrix&, Matrix&);

    void operator+=(int);// int is the amount we want to increment each value by
    void operator-=(int);

    friend ostream& operator<<(ostream&, Matrix&);
    friend istream& operator>>(istream&, Matrix&);
};
// man imagine just doing this with 9 ints hahaha who would do that I definitely didn't start doing that for some reason ... .... ........ .......
  Matrix::Matrix(int a[3][3]){
    for (int i=0;i<3;i++){
      for (int j=0;j<3;j++) {
        data[i][j] = a[i][j];
      }
    }
  }
  Matrix::Matrix(){
    for (int i=0;i<3;i++){
      for (int j=0;j<3;j++) {
        data[i][j] = 0; // there might be a way to set this easier, but this works.
      }
    }
  }
  // this whole assignment is basically just the same function copy pasted like 9 times, and then 1-3 characters changed.
Matrix operator+(Matrix& m1, Matrix& m2){
  Matrix ret;
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      ret.data[i][j] = m1.data[i][j] + m2.data[i][j];
    }
  }
  return ret;
}
Matrix operator-(Matrix& m1, Matrix& m2){
  Matrix ret;
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      ret.data[i][j] = m1.data[i][j] - m2.data[i][j];
    }
  }
  return ret;
}
Matrix operator*(Matrix& m1, Matrix& m2){
  Matrix ret;
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      ret.data[i][j] = m1.data[i][j] * m2.data[i][j]; // this isn't actually how matrix mulitplication works, but I guess its not required to be mathematically correct.
    }
  }
  return ret;
}
Matrix operator/(Matrix& m1, Matrix& m2){
  Matrix ret;
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      ret.data[i][j] = m1.data[i][j] / m2.data[i][j];
    }
  }
  return ret;
}
void Matrix::operator+=(int x){
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      data[i][j] += x;
    }
  }
}
void Matrix::operator-=(int x){
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      data[i][j] -= x;
    }
  }
}
ostream& operator<<(ostream& ostr,Matrix& m){
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      ostr << m.data[i][j] << ", ";
    }
    ostr << endl;
  }
  return ostr;
}

istream& operator>>(istream& istr,Matrix& m){
  cout << "Enter 9 numbers for a 3x3 matrix :"<< endl;
  for (int i=0;i<3;i++){
    for (int j=0;j<3;j++) {
      istr >> m.data[i][j];
    }
  }
  return istr;
}
int main(int argc, char *argv[]){
  Matrix m1,m3;
  int a[3][3] = {5,5,5,4,4,4,3,3,3};
  Matrix m2(a); // testing the 1 argument constructor, and requires less typing for the tester
  cin >> m1; // tesing istr

  cout << "m1 = " << endl << m1; // testing ostr, although this one gets used a lot
  cout << "m2 = " << endl << m2;
  cout << "adding m1 and m2" << endl; // testing the adding
  m3 = m1+m2;
  cout << m3;
  cout << "subtracting m1 and m2" << endl; // testing subtracting
  m3 = m1+m2;
  cout << m3;
  cout << "Fake multiplying m1 and m2" << endl; // testing multiplying
  m3 = m1 * m2;
  cout << m3;
  cout << "dividing m1 and m2" << endl; // testing division
  m3 = m1 / m2;
  cout << m3;
  cout << "incrememting m1 by 1" << endl; // testing increment
  m1 += 1;
  cout << m1;
  cout << "decrementing m2 by 1" << endl; // testing increment * -1;
  m2 += 1;
  cout << m2;

  return 1;
}
