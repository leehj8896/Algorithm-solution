#include <iostream>
#include <fstream>
using namespace std;

void printStar(int num)
{
    for (int i = 0; i < num; i++)
    {
        if (i % 2 == 0)
            cout << "*";
        else
            cout << "+";
    }
}

void printDash(int num)
{
    for (int i = 0; i < num; i++)
        cout << "-";
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

        for (int i = 0; i < k; i++)
        {
            if (i <= k / 2)
            {
                printDash(i);
                printStar(k - i * 2);
                printDash(i);
            }
            else
            {
                printDash(k - i - 1);
                printStar(2 * i + 2 - k);
                printDash(k - i - 1);
            }
            cout << endl;
        }
    }
}