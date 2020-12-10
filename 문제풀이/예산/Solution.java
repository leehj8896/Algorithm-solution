import java.util.Arrays;

class Solution {
    int[] budgets;
    int m;

    public int solution(int[] budgets, int M) {
        this.budgets=budgets; this.m=M;

        Arrays.sort(budgets);
        return getLimit(m,0);
    }

    private int getLimit(int n, int k) {

        int avg= n / (budgets.length-k);
        int i; int sum=0;
        for(i=k; i<budgets.length; i++){
            if(budgets[i]>avg){
                break;
            }else{
                sum+=budgets[i];
            }
        }
        if(k==i) return avg;
        if(i==budgets.length) return budgets[i-1];
        return getLimit(n-sum, i);
    }
}