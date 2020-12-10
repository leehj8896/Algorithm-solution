#include <iostream>
#include <fstream>
using namespace std;

int signedArea2(int ax, int ay, int bx, int by, int cx, int cy)
{
    return ((bx - ax) * (cy - ay) - (cx - ax) * (by - ay));
}

int main()
{
    ifstream is("input.txt");
    int t;
    is >> t;
    while (t--)
    {
        int ax, ay, bx, by, cx, cy;
        is >> ax >> ay >> bx >> by >> cx >> cy;

        int result = signedArea2(ax,ay,bx,by,cx,cy);
        if (result>0)
            cout << result << " " << 1 << endl;
        else if(result == 0)
            cout << result << " " << 0 << endl;
        else
            cout << -result << " " << -1 << endl;
    }
}