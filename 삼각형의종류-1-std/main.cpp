#include <iostream>
#include <fstream>
using namespace std;

int main(){

    ifstream is("input.txt");

    int t;
    is >> t;

    while(t--)
    {
        int a, b, c;
        is >> a >> b >> c;

        int result = 0;

        if(a + b > c)
        {
            if(a == b && b == c)
                result = 1;

            else if(a*a + b*b == c*c)
                result = 2;

            else if(a == b || b == c)
                result = 3;
            else
                result = 4;
        }

        cout << result << endl; 
    }
}