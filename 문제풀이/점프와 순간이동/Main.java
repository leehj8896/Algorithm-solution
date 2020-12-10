
class Solution {
    public int solution(int n) {
        int ans = 0;

        ans=getMin(n);

        return ans;
    }

    private int getMin(int n) {

        if(n==0) return 0;
        
        if(n%2==0){
            return getMin(n/2);
        }else{
            return 1+getMin(n/2);
        }

    }
}