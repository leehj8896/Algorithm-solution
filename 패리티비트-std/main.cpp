#include <iostream>
#include <fstream>
using namespace std;

int count(unsigned int n)
{
    int sum = 0;
    while (true)
    {
        if (n / 2 == 0 && n % 2 == 0)
            break;
        if (n % 2 == 1)
            sum++;
        n /= 2;
    }
    return sum;
}

// int main()
// {
//     //cout << count(2147483648) << endl;
//     cout << 2297235080 - 149751432 << endl;
// }

int main()
{
    ifstream is("input.txt");
    int t;
    is >> t;
    while (t--)
    {
        int n;
        is >> n;

        if(count(n) % 2 == 0)
            cout << n << endl;
        else
            cout << n + 2147483648 << endl;
            
    }
}