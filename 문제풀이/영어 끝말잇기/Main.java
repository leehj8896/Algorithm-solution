import java.util.HashMap;

class Solution {

    HashMap<String, Boolean> hashMap;

    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        hashMap=new HashMap<>();
        hashMap.put(words[0], true);
        
        for(int i=0; i<words.length-1; i++){

            if(worng(words[i], words[i+1])){
                answer=setAnswer(i+1,n);
                break;
            }
        }

        return answer;
    }

    private int[] setAnswer(int index, int n) {
        System.out.println(index+" "+n);
        int[] answer={index%n+1, index/n+1};

        return answer;
    }

    private boolean worng(String s1, String s2) {

        boolean included=hashMap.getOrDefault(s2, false);
        if(included){
            return true;
        }else{
            hashMap.put(s2, true);
        }

        if(s1.charAt(s1.length()-1)==s2.charAt(0))
            return false;

        return true;
    }
}