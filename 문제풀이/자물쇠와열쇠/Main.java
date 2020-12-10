class Main{
    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] key={
            {0, 0, 0}, 
            {1, 0, 0}, 
            {0, 1, 1}};
        int[][] lock=
        {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(s.solution(key, lock));
    }
}

class Solution {
    int m,n;
    int[][] lock, key;

    public boolean solution(int[][] key, int[][] lock) {
        m=key.length; n=lock.length;
        this.lock=lock;
        this.key=key;

        int count=0;
        while(true){
            for(int i=0; i<m+n-1; i++){
                for(int j=0; j<m+n-1; j++){
                    if(unlocked(i,j)) return true;
                }
            }

            count++;
            if(count==4) break;
            turn90();
        }
        
        return false;
    }

    private void turn90() {
        int[][] newkey=new int[m][m];

        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                newkey[j][m-i-1]=key[i][j];
            }
        }
        key=newkey;
    }

    private boolean unlocked(int starti, int startj) {

        int[][] map=new int[2*m+n-2][2*m+n-2];

        //key 복사
        for(int i=starti; i<starti+m; i++){
            for(int j=startj; j<startj+m; j++){
                map[i][j]=
                key[i-starti][j-startj];
            }
        }

        //lock 복사
        for(int i=m-1; i<m+n-1; i++){
            for(int j=m-1; j<m+n-1; j++){
                int tmpl=lock[i-m+1][j-m+1];
                int tmpm=map[i][j];
                if(tmpl==1){
                    if(tmpm==1) return false;
                }else{
                    if(tmpm==0) return false;
                }
            }
        }

        return true;
    }

    private void printMap(int[][] map) {
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}