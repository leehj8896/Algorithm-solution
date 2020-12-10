class Solution {
    public int solution(int[] arr) {

        for(int i=0; i<arr.length-1; i++){

            int gcd=getGCD(arr[i],arr[i+1]);
            arr[i+1]=arr[i] * arr[i+1]/gcd;

        }

        return arr[arr.length-1];
    }

    private int getGCD(int i, int j) {

        if(i<j){
            int tmp=i;
            i=j;
            j=tmp;
        }

        if(i%j==0) return j;
        else return getGCD(j, i%j);
    }
}