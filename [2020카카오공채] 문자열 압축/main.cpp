#include <iostream>
#include <string>
#include <vector>
using namespace std;

void printVector(vector<string> v){
    cout << "print vector!!" << endl;
    for(int i=0;i<v.size();i++){
        cout << v[i];
    }
    cout << endl;
}

int getLen(string text){

    string currentChar = "";
    int currentLength = 0;
    int totalLength = text.length();

    vector<string> compressed;
    int i=0;
    while(i < totalLength){
        
        //currentChar와 현재 문자가 다를 때 
        cout << "currentChar=" << currentChar << "\ntoString text[i]=" << to_string(text[i]) << endl;
        if(currentChar.compare(to_string(text[i])) == 0){
            //compressed.push_back(to_string(currentLength));
            cout << currentChar << endl;
            compressed.push_back(currentChar);
            currentLength = 1;
            currentChar = to_string(text[i]);
        }else{
            currentLength++;
        }
        i++;
    }

    printVector(compressed);
    return compressed.size();
}

int main(){

    string text = "aabbaccc";
    int len = getLen(text);
    cout << len << endl;
}