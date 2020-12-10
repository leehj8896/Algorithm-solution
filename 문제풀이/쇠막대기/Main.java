class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                if(s.charAt(i+1)=='('){
                    cnt++;
                }                
            }
            else if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    answer+=cnt;
                }else{
                    answer++;
                    cnt--;
                }
            }
        }

        return answer;
    }
}