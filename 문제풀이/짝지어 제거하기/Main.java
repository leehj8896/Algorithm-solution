class Solution
{
    boolean[] deleted;
    String s;

    public int solution(String s)
    {
        int answer = 0;
        deleted=new boolean[s.length()];
        this.s=s;

        while(true){

            int i=getNextI(-1);
            int nexti=getNextI(i);
            if(i>s.length()-1) return 1;

            int count=0;    
            while(true){
    
                if(s.charAt(i)==s.charAt(nexti)){
                    deleted[i]=true;
                    deleted[nexti]=true;
                    i=getNextI(nexti);
                    nexti=getNextI(i);
                    count++;
                }else{
                    i=nexti;
                    nexti=getNextI(i);
                }
                if(i>s.length()-1 || nexti>s.length()-1) break;
            }
            if(count==0) return 0;
        }

        // printS();

        // return answer;
    }

    private void printS() {

        for(int i=0; i<deleted.length; i++){
            if(!deleted[i]) System.out.print(s.charAt(i));
        }

    }

    private int getNextI(int idx) {

        int i;
        for(i=idx+1; i<deleted.length; i++){
            if(!deleted[i]) break;
        }

        return i;
    }
}