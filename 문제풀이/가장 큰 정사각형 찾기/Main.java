class Main{
    public static void main(String[] args) {

        int[][] board={
            {0,1,1,1},
            {1,1,1,1},
            {1,1,1,1},
            {0,0,1,0},
        };

        Solution s=new Solution();
        System.out.println(s.solution(board));
    }
}
class Solution
{
    int[][] board;
    boolean[][] excluded;

    public int solution(int [][]board)
    {
        this.board=board;
        int answer = 1234;

        int[][] sizes=new int[board.length][board[0].length];
        excluded=new boolean[board.length][board[0].length];


        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(!excluded[i][j]){
                    if(board[i][j]==1){
                        sizes[i][j]=getSize(i,j);
                        double tmp=Math.sqrt(sizes[i][j]);
                        for(int k=0; k<tmp; k++){
                            excluded[i+k][j+k]=true;
                        }
                    }
                }

            }
        }

        answer=getMax(sizes);
        
        return answer;
    }

    private int getSize(int i, int j) {

        int len=0;
        while(true){

            if(ifPossible(i,j,len)){
                len++;
            }else{
                break;
            }

        }

        return len*len;
    }

    private boolean ifPossible(int starti, int startj, int len) {

        for(int j=startj; j<=startj+len; j++){

            if(starti+len<board.length && j<board[0].length){
                if(board[starti+len][j]!=1){
                    return false;
                }
            }else{
                return false;
            }
        }

        for(int i=starti; i<=starti+len; i++){

            if(i<board.length && startj+len<board[0].length){

                if(board[i][startj+len]!=1){
                    return false;
                }
            }else{
                return false;
            }

        }

        return true;
    }

    private int getMax(int[][] sizes) {

        int max=0;
        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<sizes[0].length; j++){
                if(sizes[i][j]>max) max=sizes[i][j];
            }
        }

        return max;
    }
}