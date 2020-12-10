#include <iostream>
#include <fstream>
using namespace std;

void printStar(int num)
{
    for (int i = 0; i < num; i++)
        cout << "*";
}

void printPlus(int num)
{
    for (int i = 0; i < num; i++)
        cout << "+";
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

        for (int i = 0; i <= k / 2; i++)
        {
            printStar((k - 1 - 2 * i) / 2);
            printPlus(2 * i + 1);
            printStar((k - 1 - 2 * i) / 2);
            cout << endl;
        }

        for (int i = 1; i <= k / 2; i++)
        {
            printStar(i);
            printPlus(k - 2 * i);
            printStar(i);
            cout << endl;
        }
    }
}