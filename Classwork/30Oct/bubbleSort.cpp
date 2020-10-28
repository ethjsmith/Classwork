/*
*   Ethan Smith
*   Bubble Sort ICE
*   C/C++ programming
*   10/30/2020
*/

//ICE on pointers
//10/25/2020

#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

//accept two int pointers and swap them based on the contents of what they
//point to
void swap(int** num1P, int** num2P)  
{
    // cout << num1P << endl;
    // cout << num2P << endl;
    int* tmp = *num1P;
    *num1P = *num2P;
    *num2P = tmp;
    // cout << "swap" <<endl;
    // cout << num1P << endl;
    // cout << num2P << endl;
}  

//print a regular array
void printArray(int arr[], int size)  
{  
    int i;  
    for (i = 0; i < size; i++)  
        cout << arr[i] << " ";  
    cout << endl;  
}  


//this one will be very similar to the previous printArray function
void printArray(int* arr[], int size)  
{  
    int i;  
    for (i = 0; i < size; i++)  
        cout << *arr[i] << " "; // look ma, I added a character 
    cout << endl;  
}  

//The actual sorting algorithm
//have it accept an array of int pointers and a size n


void bubbleSort(int* x[], int size)  
{  
    int i = 0;
    int j = 0;
    for (i=0;i< size;i++){
        for(j=0;j< size;j++){
            // 
            if (*x[i] < *x[j]){
                swap(&x[i],&x[j]);
            }
        }
    }
    //loop until from i to 1 less than n
        //loop from j to n-i-1
            //Compare the contents of arr[j] to the contents of the next element
            //if the current element is greater than the next element swap
}

int main()
{
    /*
    1. Dynamically create an array of random numbers 1 - 100
    2. Create an array of int pointers
    3. Initialize the array by pointing each element at each int of the array
    4. implement bubble sort to sort the array of pointers
    5. Print the original array
    6. Print the sorted array using the pointers
    */
    
    
    //Dynamically create an array of 100 int
    int  nums [100];

    //Create an array of 100 int pointers
    int* pointers [100]; 
    
    //seed a random number generator
     srand(time(NULL));
    
    //initialize your 100 element array with random numbers 0 - 999
    for (int x =0; x<100; x++)
        {
            nums[x] = rand() % 999;
        }
      
    //initialize the array of pointers by pointing each at an element of the
    //array of random numbers
    for (int x =0; x<100; x++)
        {
            pointers[x] = &nums[x];
        }
    
    //moved this ? 
    //print the original array
    cout << "pre sort " << endl;
    printArray(pointers,sizeof(pointers)/sizeof(int));
    
    cout << "SORTING! ------------------------------------------" << endl;
    //sort the array of pointers by the values they point at
    bubbleSort(pointers,(sizeof(pointers)/sizeof(int)));
    
    
    
    //print the array sorted using the pointers
    printArray(pointers,sizeof(pointers)/sizeof(int));
    
    return 0;
}
