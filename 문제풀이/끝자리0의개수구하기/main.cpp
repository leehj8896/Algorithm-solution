#include <iostream>
using namespace std;

int check_2(int num);
int check_5(int num);

int main(){
    int t;      //테스트케이스
    cin >> t;

    while(t--){
        int n, count;  //숫자 개수
        cin >> n;

        int num2 = 0;
        int num5 = 0;

        while(n--){
            int num;
            cin >> num;
            num2 += check_2(num);
            num5 += check_5(num);            
        }
        //cout << num2 << endl;
        //cout << num5 << endl;
        cout << min(num2, num5) << endl;
    }
}

int check_2(int n){
    int count = 0;
    while(n % 2 == 0){
        n = n / 2;
        count++;
    }
    return count;
}
int check_5(int n){
    int count = 0;
    while(n % 5 == 0){
        n = n / 5;
        count++;
    }
    return count;
}