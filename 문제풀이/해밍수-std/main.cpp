#include <iostream>
#include <fstream>
#include <vector>
using namespace std;

void insert(int *arr, int num)
{
    int size = sizeof(arr) / sizeof(int);
    int *newArr = new int[size + 1];

    int i = 0;
    int j = 0;
    while (true)
    {
        if (i == size - 1 && j == size)
            break;
        if (num > arr[i])
        {
            newArr[j] = arr[i];
            i++;
            j++;
        }
        else
        {
            newArr[j] = num;
            j++;
        }
    }

    delete[] newArr;
}

int main()
{
    ifstream is("input.txt");
    int t;
    is >> t;
    while (t--)
    {
        int k;
        is >> k;

        int i = 1; // 2, 3, 5를 곱할 현재 해밍수의 인덱스
        int arr[] = {0, 1};
        int *newArr;
        while (true)
        {
            int size = sizeof(arr) / sizeof(int) - 1;
            if (size >= k)
                if (arr[k] < arr[i] * 2)
                    break;
            newArr = new int[size + 4];
            insert(arr, arr[i] * 2);
            insert(arr, arr[i] * 3);
            insert(arr, arr[i] * 5);
        }
        cout << arr[k] << endl;
        delete[] newArr;
    }
}

/*
1+3n > 

*/