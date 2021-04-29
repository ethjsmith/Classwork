/*
Vector Demonstration
Dr. G
10-21-19

Demo code created on cpp.sh
*/

#include <iostream>
#include <vector>

using namespace std; 


//What does "auto" do?
void printVec(vector<auto> vec , string out)
{
    cout << out  << " " << " size of = " << sizeof(vec) << " Capcity = " << vec.capacity() << " size = " << vec.size() <<endl;
	
	//foreach style loop in C++
	 for (auto const &element: vec)
        std::cout << element << ' ';
    cout << endl;
}

int main()
{
    //Vector declaration syntax
	vector <int> vec1;
	vector <int> vec2 = {1,2,3};
	vector <char> vec3 {'A','B'};
	
	//Initial view of the vectors
    // printVec(vec1, "vec 1");
    // printVec(vec2, "vec 2");
    
    
    //resize the vector to hold more data
    vec2.resize(10);
    printVec(vec2, "vec 2");
    
    //shrink it past what is currently in the vector
    vec2.resize(2);
    printVec(vec2, "vec 2");
    
    //restore it
    //what happens to the data that was removed
    vec2.resize(10);
    printVec(vec2, "vec 2");
    
    //resize with a declaration
    vec2 = {1,2,3,4};
    printVec(vec2, "vec 2");
    
    //use the vector like a stack
    vec2.pop_back();
    printVec(vec2, "vec 2");
    vec2.push_back(4);
    
    //access the vector like an array
    printVec(vec3, "vec 3");
    cout << vec3[1] << endl;
    //What happens when you try to access outside of the vector?
    //cout << vec3[3] << endl;
    //You can also use .at. What's the difference?
    
}    