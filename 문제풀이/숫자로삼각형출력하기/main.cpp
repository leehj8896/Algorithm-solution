#include <iostream>
#include <fstream>
using namespace std;

int main()
{
    ifstream is("input.txt");

    int t;
    is >> t;
    while (t--)
    {
        int k;
        is >> k;

        for (int i = 1; i <= k; i++)
        {
            int printedNumber = i;
            cout << printedNumber << " ";
            for(int j = 1; j < i; j++)
            {
                printedNumber += k - j;
                cout << printedNumber << " ";
            }
            cout << endl;
        }
    }
}