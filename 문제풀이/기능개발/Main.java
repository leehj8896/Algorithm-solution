import java.util.ArrayList;

class Solution {
    int[] progresses, speeds, days;
    ArrayList<Integer> list;

    public int[] solution(int[] progresses, int[] speeds) {
        this.progresses=progresses;
        this.speeds=speeds;
   
        days = setDays();

        int start=0, end=0;
        list = new ArrayList<>();
        while(start<days.length){
            end=getIndex(start);//2
            list.add(end-start);
            start=end;
        }

        int[] answer = setAnswer();
        // int[] answer = {};
        return answer;
    }

    private int[] setAnswer() {

        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=list.get(i);
        }

        return answer;
    }

    private int getIndex(int start) {

        int value=days[start];
        
        int i;
        for(i=start; i<days.length; i++){
            if(days[i] > value){
                return i;
            }
        }

        return i;
    }

    private int[] setDays() {

        int[] days=new int[progresses.length];

        for(int i=0; i<days.length; i++){
            int num = getNum(progresses[i], speeds[i]);
            days[i]=num;
        }
        
        return days;
    }

    private int getNum(int p, int s) {
        if((100-p)%s == 0){
            return (100-p)/s;
        }else{
            return (100-p)/s+1;
        }
    }
    
    private void printInts(int[] arr) {
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}