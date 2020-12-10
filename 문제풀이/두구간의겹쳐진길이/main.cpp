#include <iostream>
#include <fstream>
using namespace std;

int lengthOfIntervalIntersection(int a, int b, int c, int d); 

int main(){

    ifstream input("input.txt");
    int t, a, b, c, d;

    input >> t;

    while(t--){
        input >> a >> b >> c >> d;
        cout << lengthOfIntervalIntersection(a, b, c, d) << endl;

    }

    input.close();
}

int lengthOfIntervalIntersection(int a, int b, int c, int d){

    if (a <= c){
        if (b < c)
            return -1;
        else if(b <= d)
            return b - c;
        else
            return d - c;
    }else {
        if (d < a)
            return -1;
        else if(d <= b)
            return d - a;
        else
            return b - a;        
    }
}