import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public static void printStrs(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);
        printStrs(participant);
        printStrs(completion);

        int len = completion.length;
        for(int i =0; i<len;i++){
            if(participant[i].equals(completion[i])){
                continue;
            }else{
                answer = participant[i];
                break;
            }
        }
        if(answer.equals("")){
            answer=participant[len];
        }
        return answer;
    }

    public static String sol2(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String player:participant){
            hashMap.put(player, hashMap.getOrDefault(player, 0)+1);
        }
        for(String player:completion){
            hashMap.put(player, hashMap.get(player)-1);
        }
        for(String player:participant){
            if(hashMap.get(player) > 0)
                answer=player;
        }

        return answer;
    }

    public static void main(String[] args){

        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion =  	{"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
        System.out.println(sol2(participant, completion));
    }
}