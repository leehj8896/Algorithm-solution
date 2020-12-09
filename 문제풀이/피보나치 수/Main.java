class Solution {


    public int solution(int n) {
        long answer = 0;

        int[] fibo = new int[n+1];
        fibo[0]=0;
        fibo[1]=1;

        for(int i=2; i<n+1; i++){
            fibo[i]=fibo[i-1]+fibo[i-2];
        }

        answer=fibo[n];
        long tmp=answer%1234567;
        return (int)tmp;
    }
}