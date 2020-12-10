class Solution {
    public String solution(String s) {
        
        s=s.toLowerCase();

        String sum="";
        sum+=s.substring(0,1).toUpperCase();


        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==' '){
                sum+=s.charAt(i);
            }else{
                if(s.charAt(i-1)==' '){
                    sum+=s.substring(i,i+1).toUpperCase();
                }else{
                    sum+=s.charAt(i);
                }
            }
        }

        return sum;
    }
}