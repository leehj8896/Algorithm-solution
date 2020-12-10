class Solution {
    int num;
    long[] value, plus;

    public long solution(int N) {
        num=N;
        value = new long[num+1];
        plus = new long[num+1];

        plus[1]=2; value[1]=4; 
        plus[2]=2; value[2]=6;

        for(int i=3; value[num]==0; i++){
            plus[i]=plus[i-1]+plus[i-2];
            value[i]=value[i-1]+plus[i];
        }

        return value[num];
    }
}