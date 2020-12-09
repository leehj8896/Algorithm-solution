#include <iostream>
#include <fstream>
using namespace std;

class Line
{
public:
    int smallx, smally, bigx, bigy;
    bool isVertical;
    void insert(int x1, int y1, int x2, int y2)
    {
        if(x1 == x2)
        {
            isVertical = true;
            if(y1 > y2)
            {
                bigx = x1;
                bigy = y1;
                smallx = x2;
                smally = y2;
            }else
            {
                bigx = x2;
                bigy = y2;
                smallx = x1;
                smally = y1;
            }
        }else
        {
            isVertical = false;
            if(x1 > x2)
            {
                bigx = x1;
                bigy = y1;
                smallx = x2;
                smally = y2;
            }else
            {
                bigx = x2;
                bigy = y2;
                smallx = x1;
                smally = y1;
            }            
        }        
    }
};

int isCross(Line line1, Line line2)
{
    if(line1.isVertical == true)
    {
        if(line2.bigy > line1.bigy || line2.bigy < line1.smally)
            return 0;
        if(line1.bigy == line2.bigy || line1.smally == line2.smally){
            if(line1.smallx < line2.smallx || line1.smallx > line2.bigx)
                return 0;
            return 2;
        }
        if (line1.smallx < line2.smallx || line1.smallx > line2.bigx)
            return 0;
        if(line1.smallx == line2.smallx || line1.smallx == line2.bigx)
            return 2;
        return 1;
    }else{
        if(line1.bigy > line2.bigy || line1.bigy < line2.smally)
            return 0;
        if(line2.bigy == line1.bigy || line2.smally == line1.smally){
            if(line2.smallx < line1.smallx || line2.smallx > line1.bigx)
                return 0;
            return 2;
        }
        if (line2.smallx < line1.smallx || line2.smallx > line1.bigx)
            return 0;
        if(line2.smallx == line1.smallx || line2.smallx == line1.bigx)
            return 2;
        return 1;
    }
}

int main()
{
    ifstream is("input.txt");
    int t;
    is >> t;

    while(t--)
    {
        Line line[2];
        for(int i = 0; i < 2; i++)
        {
            int x1, y1, x2, y2;
            is >> x1 >> y1 >> x2 >> y2;
            line[i].insert(x1,y1,x2,y2);
        }
        
        cout << isCross(line[0], line[1]) << endl;
    }
}