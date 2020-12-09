import java.util.LinkedList;

class Solution {
    int[][] triangle;
    boolean[][] selected;
    LinkedList<Integer> sums;
    int max;

    public int solution(int[][] triangle) {
        this.triangle=triangle;
        sums=new LinkedList<>();
        selected=new boolean[triangle.length][triangle.length];

        max=0;

        selected[0][0]=true;
        select(0,0);
         

        return max;
    }

    private int select(int i, int j) {

        if(i==triangle.length-1){
            // int sum=getSum();
            // if(max<sum) max=sum;
            // sums.add(sum);
        }else{
            selected[i+1][j]=true;
            select(i+1,j);
            selected[i+1][j]=false;
            selected[i+1][j+1]=true;
            select(i+1,j+1);
            selected[i+1][j+1]=false;
        }
    }

    private int getSum() {

        int sum=0;
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<i+1; j++){
                if(selected[i][j]) sum+=triangle[i][j];
            }
        }

        return sum;
    }
}