class Solution {

    boolean[] included;
    int count;
    int[] nums;

    public int solution(int[] nums) {

        this.nums=nums;
        included=new boolean[nums.length];
        count=0;

        checkComb(0,3);

        return count;
    }

    private void checkComb(int idx, int r) {

        if(r==0){
            int sum=getSum();
            // System.out.println(sum);
            if(isPrime(sum)){
                count++;
            }
            return;
        }
        if(idx==nums.length) return;

        included[idx]=true;
        checkComb(idx+1, r-1);

        included[idx]=false;
        checkComb(idx+1, r);

    }

    private boolean isPrime(int sum) {

        int sqt= (int) Math.sqrt(sum);
        
        for(int i=2; i<=sqt; i++){
            if(sum%i==0) return false;
        }

        return true;
    }

    private int getSum() {

        int sum=0;
        for(int i=0; i<included.length; i++){
            if(included[i]){
                sum+=nums[i];
                // System.out.print(nums[i]+" ");
            }
        }
        // System.out.println();
        return sum;
    }

}