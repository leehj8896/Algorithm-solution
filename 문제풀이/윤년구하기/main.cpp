#include <iostream>
using namespace std;

int main(){
    int t;
    cin >> t;

    while(t--){
        int y;
        cin >> y;

        if(y % 400 == 0)
            cout << 1 << endl;
        else if(y % 100 == 0)
            cout << 0 << endl;
        else if(y % 4 == 0)
            cout << 1 << endl;
        else
            cout << 0 << endl;
    }
}