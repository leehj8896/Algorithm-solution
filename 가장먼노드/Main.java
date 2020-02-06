import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    int n;
    int[][] edge;
    LinkedList<Integer> list;
    int[] level;


    public int solution(int n, int[][] edge) {
        this.n=n; this.edge=edge;
        list=new LinkedList<>();
        level=new int[n+1];
        list.add(1);
        level[1]=1;

        int count=0;
        while(true){
            if(count==n) break;
            int current=list.pollFirst();
            for(int i=0; i<edge.length; i++){
                if(edge[i][0]==current){
                    if(level[edge[i][1]]==0){
                        list.add(edge[i][1]); 
                        level[edge[i][1]]=level[edge[i][0]]+1;
                    }
                }else if(edge[i][1]==current){
                    if(level[edge[i][0]]==0){
                        list.add(edge[i][0]);
                        level[edge[i][0]]=level[edge[i][1]]+1;
                    }
                }
            }
            count++;
        }
        return countMaxLevel();
    }

    private int countMaxLevel() {
        Arrays.sort(level);
        int count=0;
        for(int i=n; i>=0; i--){
            if(level[i]==level[n]) count++;
        }
        return count;
    }
}