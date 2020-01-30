import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static int[] solution(String msg) {
        int[] answer = {}; Answer a= new Answer(msg);
        answer=a.get();
        return answer;
    }public static void main(String[] args) {
        String msg="TOBEORNOTTOBEORTOBEORNOT";
        printIntegers(solution(msg));
    }

    private static void printIntegers(int[] arr) {
        for(int i:arr) System.out.print(i+" ");
        System.out.println();
    }
  }

class Answer {
    String msg;
    HashMap<String, Integer> hashMap;

    public Answer(String msg) {
        this.msg = msg;
        hashMap=new HashMap<>();
        for(int i=65; i<=90; i++)
            hashMap.put((char)i+"", i-64);
    }

    public int[] get() {
        
        LinkedList<Integer> list=new LinkedList<>();
        int index=27;
        while(true){
            int[] indice = findWIndex();
            String w = msg.substring(indice[0],indice[1]);
            int num = hashMap.get(w);
            list.add(num);
            if(indice[1] < msg.length()){
                msg = msg.substring(indice[1],msg.length());        
                hashMap.put(w+msg.substring(0,1), index);
                // System.out.println(w+"\t"+msg.substring(0,1)+"\t"+num+"\t"+w+msg.substring(0,1));
                index++;
            }else{
                break;
            }
        }

        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++) result[i]=list.get(i);
        return result;
    }

    private int[] findWIndex() {
        int[] indice={0,1};
        int start=0, end=1;
        for(;end<=msg.length(); end++){
            int num = hashMap.getOrDefault(msg.substring(start,end), 0);
            if(num!=0){
                indice[1]=end;
            }
        }
        // System.out.println(msg+"\t"+indice[0]+", "+indice[1]);
        return indice;
    }

}