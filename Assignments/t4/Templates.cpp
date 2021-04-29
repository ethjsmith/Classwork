
/* (modified by ) Ethan Smith
 * C++ Final Practical
 * Templates file
 * 12/16/20
 */


//Template practical

//Worth 10 Points

//Analyze the below code and rewrite using a template
//Then, uncomment the 2nd section of the main to test


//tested on cpp.sh


#include <iostream>

using namespace std;
template <typename T>
void bubbleSort(T a[], int n) {
  for (int i = 0; i < n - 1; i++)
      for (int j = n - 1; i < j; j--)
          if (a[j] < a[j - 1])
            swap(a[j], a[j - 1]);
}

// void bubbleSort(int a[], int n) {
//     for (int i = 0; i < n - 1; i++)
//         for (int j = n - 1; i < j; j--)
//             if (a[j] < a[j - 1])
//               swap(a[j], a[j - 1]);
// }

template <typename T>
void swap(T* x, T* y){
  T temp = *y;
  *y = *x;
  *x=temp;
}
// void swap(int* x, int* y)
// {
// 	int temp=*y;
// 	*y = *x;
// 	*x=temp;
// }
template <typename T>
void print(T array[], int size){
  for (int x = 0; x < size; x++) cout << array[x] << " ";
}
// void print(int array [], int size)
// {
// 	for (int x = 0; x < size; x++) cout << array[x] << " ";
// }

int main()
{
    int a[5] = {10, 50, 30, 40, 20};
    int n = sizeof(a) / sizeof(a[0]);

    bubbleSort(a, 5);

    cout << " Sorted array : ";
    print(a, n);

	//PART 2

	double b[5] = {10.3, 10.2, 34.7, 40.0, 20.2};
    n = sizeof(b) / sizeof(b[0]);

    bubbleSort(b, 5);

    cout << " Sorted array : ";
    print(b, n);


	char c[5] = {'z', 'a', 'j', 'm', 'c'};
    n = sizeof(c) / sizeof(c[0]);

    bubbleSort(c, 5);

    cout << " Sorted array : ";
    print(c, n);
}
