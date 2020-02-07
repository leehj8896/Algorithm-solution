import java.util.HashMap;

class Solution {
    String[] participant, completion;
    HashMap<String, Integer> hashMap;

    public String solution(String[] participant, String[] completion){
        this.participant=participant;
        this.completion=completion;
        hashMap=new HashMap<>();

        for(String s:completion){
            hashMap.put(s, hashMap.getOrDefault(s, 0)+1);
        }
        for(String s:participant){
            int tmp=hashMap.getOrDefault(s, 0);
            if(tmp==0) return s;
            hashMap.put(s, tmp-1);
        }
        
        return null;
    }
}