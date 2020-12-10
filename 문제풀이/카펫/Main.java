class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = {-1,-1};


        //약수
        int[] small=getSmall(red);
        // printSmall(small);
        for(int a:small){

            //a==1
            int b=red/a;

            if(((a+2)*(b+2)-red)==brown){
                answer[0]=b+2;
                answer[1]=a+2;
                return answer;
            }

        }

        return answer;
    }

    private void printSmall(int[] small) {
        for(int e:small){
            System.out.print(e+" ");
        }
        System.out.println();
    }

    private int[] getSmall(int red) {

        boolean[] isA=new boolean[red+1];
        for(int i=1; i<=red; i++){
            if(red%i==0){
                isA[i]=true;
            }
        }

        int num=getNum(isA);

        int[] small=new int[num];

        int i=0;
        int j=1;
        while(i<num){
            if(isA[j]==true){
                small[i]=j;
                i++;
                j++;
            }else{
                j++;
            }
        }

        return small;
    }

    private int getNum(boolean[] isA) {
        int num=0;
        for(int i=0; i<isA.length; i++){
            if(isA[i]) num++;
        }
        return num;
    }
}