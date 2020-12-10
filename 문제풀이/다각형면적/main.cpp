#include <iostream>
#include <fstream>
using namespace std;

class Point
{
public:
    int x, y;
};

int signedArea2(Point *arr, int size)
{
    int sum = 0;
    for (int i = 0; i < size; i++)
    {
        if (i == size - 1)
            sum += (arr[i].x + arr[0].x) * (arr[0].y - arr[i].y);
        else
            sum += (arr[i].x + arr[i + 1].x) * (arr[i + 1].y - arr[i].y);
    }
    return sum;
}

int main()
{
    ifstream is("input.txt");
    int t;
    is >> t;
    while (t--)
    {
        int n;
        is >> n;
        Point *arr = new Point[n];

        for(int i = 0; i < n; i++)
        {
            is >> arr[i].x >> arr[i].y;
        }

        int sa = signedArea2(arr, n);
        if (sa > 0)
            cout << sa << " " << 1 << endl;
        else if (sa == 0)
            cout << sa << " " << 0 << endl;
        else
            cout << -sa << " " << -1 << endl;

        delete[] arr;
    }
}
