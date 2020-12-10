class Solution {
    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        Answer a=new Answer(m,n,board);
        answer=a.get();
        return answer;
    }public static void main(String[] args) {
        int m=6;    int n=6;    
        String[] board={
            "TTTANT", 
            "RRFACC", 
            "RRRFCC", 
            "TRRRAA", 
            "TTMMMF", 
            "TMMTTJ"};
        System.out.println(solution(m, n, board));
    }
  }

class Answer {
    int m; 
    int n; 
    char[][] board;
    boolean[][] check;
    int count;
    public Answer(int m, int n, String[] data) {
        this.m=m;   this.n=n;
        board= new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=data[i].charAt(j);
            }
        }
    }

    public int get() {

        int sum=0;
        while(true){
            check = new boolean[m][n];
            count = 0;
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    check22(i,j);
                }
            }
            clearBoard();
            if(count==0){
                break;
            }
            sum+=count;
            dropBoard();
        }
        return sum;
    }

    private void clearBoard() {
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(check[i][j]==true){
                    board[i][j]= ' ';
                    count++;
                }
            }
        }
    }

    private void dropBoard() {
        for(int j=0;j<n;j++){
            for(int i=m-1;i>0;i--){
                if(board[i][j]==' '){
                    int index=findJ(i,j);
                    if(index>=0){
                        board[i][j]=board[index][j];
                        board[index][j]=' ';
                    }
                }
            }
        }
    }

    private int findJ(int i, int j) {
        int index=-1;
        for(int k=i-1;k>=0;k--){
            if(board[k][j]!=' '){
                index=k;
                break;
            }
        }
        return index;
    }

    private void check22(int i, int j) {
        char c1 = board[i][j];
        char c2 = board[i][j+1];
        char c3 = board[i+1][j];
        char c4 = board[i+1][j+1];
        if(c1!=' '){
            if(c1==c2&&c2==c3&&c3==c4){
                check[i][j]=true;
                check[i][j+1]=true;
                check[i+1][j]=true;
                check[i+1][j+1]=true;
            }
        }
    }
}