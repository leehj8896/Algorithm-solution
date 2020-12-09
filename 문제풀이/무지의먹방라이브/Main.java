class Main{
    public static void main(String[] args) {
        int[] f={1000};
        int k=1;
        Solution s=new Solution();
        System.out.println(s.solution(f, k));
    }
}

class Solution {
    int[] food_times;

    public int solution(int[] food_times, long k) {
        this.food_times=food_times;
        
        while(true){
            if(k==0) break;

            long min = getMin();
            if(min==-1) return -1;

            long sum = getSum(min);
            
            if(k-sum>=0){
                subMins(sum, min);
                k-=sum;
            }else{
                subMins(k, 1);
                k=0;
            }
            // printFs();
        }
        int index=getIndex();

        return index;
    }

    private void printFs() {
        for(int i=0; i<food_times.length; i++){
            System.out.print(food_times[i]+" ");
        }
        System.out.println();
    }

    private int getIndex() {

        for(int i=0; i<food_times.length; i++){
            if(food_times[i]>0){
                return i+1;
            }
        }

        return -1;
    }

    private void subMins(long sum, long min) {

        for(int i=0; sum>0; i++){

            if(food_times[i]>0){
                food_times[i]-=min;
                sum-=min;
            }
        }

    }

    private long getSum(long min) {

        long num=0;
        for(int i=0; i<food_times.length; i++){
            if(food_times[i]>0) num++;
        }
        return min*num;
    }

    private long getMin() {

        long min = 100000001;
        for(int i=0; i<food_times.length; i++){
            if(food_times[i]>0){
                if(min>food_times[i]) min=food_times[i];
            }
        }

        if(min==100000001) return -1;

        return min;
    }
}