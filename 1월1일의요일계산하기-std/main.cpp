#include <iostream>
using namespace std;

int check_leap(int year);

int main()
{
    int t;
    cin >> t;

    while (t--)
    {
        int y;
        cin >> y;

        int count = 5;

        for(int i = 1582; i < y; i++){
            if(check_leap(i) == 0)
                count += 365;
            else
                count += 366;
        }
        cout << count % 7 << endl;
    }
}

int check_leap(int year)
{
    if (year % 400 == 0)
        return 1;
    else if (year % 100 == 0)
        return 0;
    else if (year % 4 == 0)
        return 1;
    else
        return 0;
}



