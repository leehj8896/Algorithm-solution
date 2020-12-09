#include <iostream>
#include <fstream>
#include <cmath>
#include <algorithm>
using namespace std;

int length(int x1, int y1, int x2, int y2)
{
    return pow(x1 - x2, 2) + pow(y1 - y2, 2);
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

        int line[3];
        line[0] = length(ax, ay, bx, by);
        line[1] = length(bx, by, cx, cy);
        line[2] = length(cx, cy, ax, ay);

        sort(line, line + 3);

        int result = 0;
        if (sqrt(line[2]) >= sqrt(line[0]) + sqrt(line[1]))
            result = 0;
        else if (line[2] == line[1] + line[0])
            result = 1;
        else if (line[2] < line[1] + line[0])
            result = 3;
        else if (line[2] > line[1] + line[0])
            result = 2;

        cout << result << endl;
    }
}