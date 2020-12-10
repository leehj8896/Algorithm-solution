import java.util.ArrayList;

class Solution {
    int[][] baseball;
    int[] include;
    ArrayList<String> list;
    boolean[] wrong;

    public int solution(int[][] baseball) {
        this.baseball=baseball;
        include=new int[10];
        list=new ArrayList<>();

        addCase(1);
        wrong=new boolean[list.size()];

        for(int[] e:baseball){
            for(int i=0; i<list.size(); i++){
                if(isWrong(e,list.get(i))) wrong[i]=true;
            }
        }       

        return getNotWrongNum();
    }

    private int getNotWrongNum() {
        int count=0;
        for(int i=0; i<wrong.length; i++){
            if(wrong[i]==false) count++;
        }
        return count++;
    }

    private boolean isWrong(int[] e, String str) {

        int s=0, b=0;
        String tmp=e[0]+"";
        for(int i=0; i<3; i++){
            char c1=tmp.charAt(i);
            for(int j=0; j<3; j++){
                char c2=str.charAt(j);
                if(c1==c2){
                    if(i==j){
                        s++;
                    }else{
                        b++;
                    }
                }
            }
        }
        if(s==e[1] && b==e[2]) return false;
        return true;
    }
    
    private void addCase(int k) {
        if(k==4){
            String tmp=getStr();
            list.add(tmp);
        }else{
            for(int i=1; i<=9; i++){
                if(include[i]==0){
                    include[i]=k;
                    addCase(k+1);
                    include[i]=0;
                }
            }
        }
    }

    private String getStr() {
        String sum="";
        int n1=0,n2=0,n3=0;
        for(int i=1; i<10; i++){
            if(include[i]==1) n1=i;
            else if(include[i]==2) n2=i;
            else if(include[i]==3) n3=i;
        }
        sum+=n1;sum+=n2;sum+=n3;
        return sum;
    }
}