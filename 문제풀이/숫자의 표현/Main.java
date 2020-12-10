class Solution {
    public int solution(int n) {
        int count = 0;
 
        int i=1;
        while(true){

            int sum=getSum(i);
            if((n-sum)%i==0){
                if((n-sum)/i<1) break;
                count++;
            }
            i++;
        }

        return count;
    }

    private int getSum(int num) {

        int sum=0;
        for(int i=0; i<num; i++){
            sum+=i;
        }

        return sum;
    }
}