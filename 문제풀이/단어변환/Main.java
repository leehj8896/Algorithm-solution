import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    LinkedList<String> list;
    String[] words;
    HashMap<String, Integer> depthTo;
    
    public int solution(String begin, String target, String[] words) {

        this.words=words;
        list=new LinkedList<>();
        depthTo=new HashMap<>();

        depthTo.put(begin, 0); 
        list.addLast(begin);
        while(true){
            if(list.isEmpty()) break;

            String currentStr = list.pollFirst();
            
            for(int i=0; i<currentStr.length(); i++){
                for(int j=97; j<=122; j++){
                    String newStr = sub(currentStr, i, j);
                    int k=isIn(newStr);
                    if(k!=-1 && depthTo.getOrDefault(newStr,-1)==-1){
                        depthTo.put(newStr, depthTo.getOrDefault(currentStr, -1)+1);
                        list.add(newStr);
                    }
                }
            }
        }
        return depthTo.getOrDefault(target, 0);
    }

    private int isIn(String newStr) {
        int index=-1;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(newStr)) index=i;
        }

        return index;
    }

    private String sub(String str, int index, int num) {
        String sum="";
        if(index>0) sum+=str.substring(0,index);
        sum+=(char)num;
        if(index+1<str.length()) sum+=str.substring(index+1,str.length());

        return sum;
    }
}