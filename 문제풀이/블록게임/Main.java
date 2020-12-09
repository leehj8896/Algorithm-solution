class Main{
    public static void main(String[] args) {
        // int[][] board={
        //     {0,0,0,0,0,0,0,0,0,0},
        //     {0,0,0,0,0,0,0,0,0,0},
        //     {0,0,0,0,0,0,0,0,0,0},
        //     {0,0,0,0,0,0,0,0,0,0},
        //     {0,0,0,0,0,0,4,0,0,0},
        //     {0,0,0,0,0,4,4,0,0,0},
        //     {0,0,0,0,3,0,4,0,0,0},
        //     {1,0,0,2,3,0,0,0,5,5},
        //     {1,2,2,2,3,3,0,0,0,5},
        //     {1,1,0,0,0,0,0,0,0,5}
        // };
        int[][] board =
            {{0,0,0,0,0,0,0,0,0,0}
            ,{0,0,0,0,0,0,0,0,0,0}
            ,{0,0,0,0,0,0,0,0,0,0}
            ,{0,0,0,0,0,0,0,0,0,0}
            ,{0,0,0,2,2,0,0,0,0,0}
            ,{0,0,0,2,1,0,0,0,0,0}
            ,{0,0,0,2,1,0,0,0,0,0}
            ,{0,0,0,0,1,1,0,0,0,0}
            ,{0,0,0,0,0,0,0,0,0,0}
            ,{0,0,0,0,0,0,0,0,0,0}};
        Solution s= new Solution();
        System.out.println(s.solution(board));
    }
}
class Solution {

    boolean[] excluded;
    int[][] board;

    public int solution(int[][] board) {

        this.board=board;
        excluded = new boolean[board.length];

        int start=0, count=0;
        while(true){
            start=findI(start);
            if(start<0){
                break; 
            }else{
                count++;
                // printBoards();
            }
        }

        return count;
    }

    private void printBoards() {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private int findI(int start) {

        for(int i=start; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j]!=0){
                    if(!excluded[j]){
                        if(changeIfPossible(i, j)){
                            return i;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean changeIfPossible(int i, int j) {
        if(case01(i,j)){
            excluded[j]=true;
            excluded[j+1]=true;
            excluded[j+2]=true;
            return false;
        }
        if(case02(i,j)){
            excluded[j]=true;
            excluded[j+1]=true;
            return false;
        }
        if(case03(i,j)){
            if(excluded[j]||excluded[j+1]||excluded[j+2]){
                excluded[j]=true;
                excluded[j+1]=true;
                excluded[j+2]=true;
                return false;
            }else{
                board[i][j]=0;
                board[i+1][j]=0;
                board[i+1][j+1]=0;
                board[i+1][j+2]=0;
                return true;
            }
        }
        if(case04(i,j)){
            if(excluded[j]||excluded[j-1]){
                excluded[j]=true;
                excluded[j-1]=true;
                return false;
            }else{
                board[i][j]=0;
                board[i+1][j]=0;
                board[i+2][j]=0;
                board[i+2][j-1]=0;
                return true;
            }
        }
        if(case05(i,j)){
            excluded[j]=true;
            excluded[j+1]=true;
            excluded[j+2]=true;
            return false;
        }
        if(case06(i,j)){
            if(excluded[j]||excluded[j+1]){
                excluded[j]=true;
                excluded[j+1]=true;
                return false;
            }else{
                board[i][j]=0;
                board[i+1][j]=0;
                board[i+2][j]=0;
                board[i+2][j+1]=0;
                return true;
            }
        }
        if(case07(i,j)){
            if(excluded[j]||excluded[j-1]||excluded[j-2]){
                excluded[j]=true;
                excluded[j-1]=true;
                excluded[j-2]=true;
                return false;
            }else{
                board[i][j]=0;
                board[i+1][j]=0;
                board[i+1][j-1]=0;
                board[i+1][j-2]=0;
                return true;
            }
        }
        if(case08(i,j)){
            excluded[j]=true;
            excluded[j+1]=true;
            return false;
        }
        if(case09(i,j)){
            if(excluded[j]||excluded[j-1]||excluded[j+1]){
                excluded[j]=true;
                excluded[j-1]=true;
                excluded[j+1]=true;
                return false;
            }else{
                board[i][j]=0;
                board[i+1][j]=0;
                board[i+1][j-1]=0;
                board[i+1][j+1]=0;
                return true;
            }
        }
        if(case10(i,j)){
            excluded[j]=true;
            excluded[j+1]=true;
            return false;
        }
        if(case11(i,j)){
            excluded[j]=true;
            excluded[j+1]=true;
            excluded[j+2]=true;
            return false;
        }
        if(case12(i,j)){
            excluded[j]=true;
            excluded[j-1]=true;
            return false;
        }
        
        return false;
    }

    private boolean case12(int i, int j) {
        if(i+2<board.length&&j-1>=0){
            if(
                board[i][j]==board[i+2][j]&&
                board[i][j]==board[i+1][j-1]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case11(int i, int j) {
        if(i+1<board.length&&j+2<board.length){
            if(
                board[i][j]==board[i][j+2]&&
                board[i][j]==board[i+1][j+1]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case10(int i, int j) {
        if(i+2<board.length&&j+1<board.length){
            if(
                board[i][j]==board[i+1][j+1]&&
                board[i][j]==board[i+2][j]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case09(int i, int j) {
        if(i+1<board.length&&j-1>=0&&j+1<board.length){
            if(
                board[i][j]==board[i+1][j-1]&&
                board[i][j]==board[i+1][j+1]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case08(int i, int j) {
        if(j+1<board.length&&i+2<board.length){
            if(
                board[i][j]==board[i][j+1]&&
                board[i][j]==board[i+2][j+1]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case07(int i, int j) {
        if(i+1<board.length&&j-2>=0){
            if(
                board[i][j]==board[i+1][j]&&
                board[i][j]==board[i+1][j-2]
            ){
                return true;
            }
        }

        return false;
    }

    private boolean case06(int i, int j) {
        if(i+2<board.length&&j+1<board.length){

            if(
                board[i][j]==board[i+2][j]&&
                board[i][j]==board[i+2][j+1]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case05(int i, int j) {
        
        if(j+2<board.length&&i+1<board.length){

            if(
                board[i][j]==board[i][j+2]&&
                board[i][j]==board[i+1][j]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case04(int i, int j) {
        
        if(i+2<board.length&&j-1>=0){

            if(
                board[i][j]==board[i+2][j]&&
                board[i][j]==board[i+2][j-1]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case03(int i, int j) {
        if(i+1<board.length&&j+2<board.length){

            if(
                board[i][j]==board[i+1][j]&&
                board[i][j]==board[i+1][j+2]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case02(int i, int j) {
        
        if(j+1<board.length&&i+2<board.length){
            if(
                board[i][j]==board[i][j+1]&&
                board[i][j]==board[i+2][j]
            ){
                return true;
            }
        }
        return false;
    }

    private boolean case01(int i, int j) {

        if(i+1<board.length && j+2<board.length){
            if(
                board[i][j]==board[i][j+2]&&
                board[i][j]==board[i+1][j+2]
            ){
                return true;
            }
        }
        return false;
    }
}