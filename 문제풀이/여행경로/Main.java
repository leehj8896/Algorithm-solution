import java.util.Collections;
import java.util.LinkedList;

class Solution {
    LinkedList<String> route, result;
    boolean[] used;
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        result= new LinkedList<>(); 
        this.tickets=tickets;

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                used=new boolean[tickets.length];
                route=new LinkedList<>();
                route.add(tickets[i][0]);
                used[i]=true;
                depart(tickets[i][1], 1);
            }          
        }

        Collections.sort(result);
        
        return toArr(result.getFirst());
    }

    // 도착지(end)를 add하는 함수. k<len 인 동안
    private void depart(String end, int k) {
        route.add(end);
        if(k == tickets.length){
            result.add(route.toString());
        }else{
            for(int i=0; i<tickets.length; i++){
                if(tickets[i][0].equals(end) && used[i]==false){
                    used[i]=true;
                    depart(tickets[i][1], k+1);
                    used[i]=false;
                    route.removeLast();
                }
            }
        }
    }

    private String[] toArr(String s) {
        String tmp=s.substring(1,s.length()-1);
        return tmp.split(", ");
    }
}