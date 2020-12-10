import java.util.*;

class Solution {
    int[] citations;
    public int solution(int[] citations) {
        int answer = 0;
        this.citations=citations;
        Arrays.sort(citations);

        for(int i=citations[citations.length-1]; i>=0; i--){
            int count = getCount(i);
            if(count >= i){
                answer=i; 
                break;
            }
        }
        return answer;
    }

    private int getCount(int h) {
        int count=0;
        for(int i=citations.length-1; i>=0; i--){
            if(citations[i]>=h){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}