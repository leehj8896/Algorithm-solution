import java.util.Arrays;

class Solution {
    int[] lens;
    String s;

    public int solution(String s){
        if(s.length()==1) return 1;
        
        lens=new int[s.length()/2];
        this.s=s;
    
        for(int i=0; i<lens.length; i++){
            int len = getLen(i+1);
            lens[i]=len;
        }

        Arrays.sort(lens);

        return lens[0];
    }

    private int getLen(int slice) {

        String sum=""; String counted=""; 
        if(slice<=s.length())
            counted=s.substring(0,slice);
        else{
            return s.length();
        }

        int count=0; int i;
        for(i=0; i<s.length(); i+=slice){
            String current="";
            if(i+slice <= s.length()) current=s.substring(i,i+slice);
            else current=s.substring(i,s.length());
            
            if(current.equals(counted)){
                count++;
            }else{
                if(count>1) sum+=count;
                sum+=counted;
                counted=current;
                count=1;
            }    
        }

        if(i == s.length()){
            if(count>1) sum+=count;
            sum+=counted;
        }else{
            sum+=s.substring(i-slice,s.length());
        }

        return sum.length();
    }
}