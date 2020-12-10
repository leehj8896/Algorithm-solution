class Solution {

    int[][] arr1,arr2;

    public int[][] solution(int[][] arr1, int[][] arr2) {
        this.arr1=arr1;
        this.arr2=arr2;
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[0].length; j++){

                answer[i][j]=getSum(i,j);

            }
        }  

        return answer;
    }

    private int getSum(int i, int j) {

        int sum=0;
        
        for(int k=0; k<arr1[i].length; k++){
            sum += arr1[i][k] * arr2[k][j];
        }

        return sum;
    }
}