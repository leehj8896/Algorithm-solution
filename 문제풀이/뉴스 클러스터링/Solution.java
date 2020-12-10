import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public static int solution(String str1, String str2) {
        int answer = 0;

        Answer a = new Answer(str1, str2);
        answer = a.getAnswer();
        return answer;
    }

    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1, str2));
    }
}

class Answer {

    String str1, str2;
    LinkedList<String> strs1, strs2;
    Collection<Integer> sum;
    int len1, len2;
    HashMap<String, Integer> hashMap1, hashMap2;
    Set<String> keySet1,keySet2;

    public Answer(String str1, String str2) {
        this.str1=str1; this.str2=str2;
    }

    public int getAnswer() {

        len1=str1.length();         len2=str2.length();
        strs1 = new LinkedList<>(); strs2 = new LinkedList<>();
        for(int i = 0; i < len1-1; i++){
            if(isAlphabet(str1.charAt(i)) && isAlphabet(str1.charAt(i+1))){
                char tmp1=0, tmp2=0;
                if(isUpper(str1.charAt(i))){
                    tmp1=(char)((int)str1.charAt(i) + 32);
                }else{
                    tmp1=str1.charAt(i);
                }
                if(isUpper(str1.charAt(i+1))){
                    tmp2=(char)((int)str1.charAt(i+1) + 32);
                }else{
                    tmp2=str1.charAt(i+1);
                }
                strs1.add(Character.toString(tmp1)+Character.toString(tmp2));
            }
        }
        for(int i = 0; i < len2-1; i++){
            if(isAlphabet(str2.charAt(i)) && isAlphabet(str2.charAt(i+1))){
                char tmp1=0, tmp2=0;
                if(isUpper(str2.charAt(i))){
                    tmp1=(char)((int)str2.charAt(i) + 32);
                }else{
                    tmp1=str2.charAt(i);
                }
                if(isUpper(str2.charAt(i+1))){
                    tmp2=(char)((int)str2.charAt(i+1) + 32);
                }else{
                    tmp2=str2.charAt(i+1);
                }
                strs2.add(Character.toString(tmp1)+Character.toString(tmp2));
            }
        }
        // printStrs(strs1);printStrs(strs2);
        hashMap1 = new HashMap<>(); 
        hashMap2 = new HashMap<>(); 
        for(String str:strs1)
            hashMap1.put(str, hashMap1.getOrDefault(str, 0)+1);
        for(String str:strs2)
            hashMap2.put(str, hashMap2.getOrDefault(str, 0)+1);
        
        System.out.println(hashMap1.toString());
        System.out.println(hashMap2.toString());

        int c = 0;
        keySet1 = hashMap1.keySet();
        keySet2 = hashMap2.keySet();
        System.out.println(keySet1);
        for(String element:keySet1){
            int tmp1 = hashMap1.getOrDefault(element, 0);
            int tmp2 = hashMap2.getOrDefault(element, 0);
            if(tmp1 != 0 && tmp2 != 0){
                if(tmp1>tmp2){
                    c += tmp2;
                    hashMap1.put(element, tmp1-tmp2);
                    hashMap2.put(element, 0);
                }else{
                    c += tmp1;
                    hashMap1.put(element, 0);
                    hashMap2.put(element, tmp2-tmp1);
                }
            }
        }

        int p = 0;
        for(String element:keySet1){
            int tmp = hashMap1.getOrDefault(element, 0);
            if(tmp != 0){
                p += tmp;
                hashMap1.put(element, 0);
            }
        }

        for(String element:keySet2){
            int tmp = hashMap2.getOrDefault(element, 0);
            if(tmp != 0){
                p += tmp;
                hashMap2.put(element, 0);
            }
        }

        System.out.println(hashMap1.toString());
        System.out.println(hashMap2.toString());

        if(c+p==0){
            return 65536;
        }
        double result = (double)c/(c+p) * 65536;   
        return (int)result;
    }

    private boolean isUpper(char charAt) {
        if(65<=(int)charAt && (int)charAt <= 90)
            return true;
        return false;
    }

    private boolean isAlphabet(char charAt) {
        if(65<=(int)charAt && (int)charAt<=90 ||
        97<=(int)charAt && (int)charAt<=122
        )
            return true;
        return false;
    }

    private void printStrs(LinkedList<String> strs) {
        for(int i=0; i<strs.size(); i++){
            System.out.print(strs.get(i) + " ");
        }
        System.out.println();
    }
}