import java.util.LinkedList;

class Solution {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        Answer a= new Answer(m, musicinfos);
        answer=a.get();
        return answer;
    }public static void main(String[] args) {
        String m="ABCDEFG";
        String[] musicinfos={
            "12:00,12:14,HELLO,CDEFGAB", 
            "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m,musicinfos));
    }
  }

class Answer{
    String m;
    String[] musicinfos, names;
    int[] count;
    int[] time;
    int num;
    public Answer(String m, String[] musicinfos) {
        this.m=m;
        this.musicinfos=musicinfos;
        num=musicinfos.length;
        count=new int[num];
        time=new int[num];
        names=new String[num];
    }

    public String get() {
        m=change(m);
        // System.out.println(m);
        int maxCount=0;
        int maxCountIndex=0;
        for(int i=0; i<num;i++){
            String[] strs=musicinfos[i].split(",");
            names[i]=strs[2];
            time[i]=getTime(strs[0],strs[1]);
            // System.out.println(time[i]+" "+strs[3]);
            count[i]=getCount(time[i],change(strs[3]));
            if(maxCount<count[i]){
                maxCount=count[i];
                maxCountIndex=i;
            }
        }
        if(maxCount==0)
            return "(None)";

        int maxTime=0;
        int maxTimeIndex=maxCountIndex;
        for(int i=0; i<num;i++){
            if(count[i]==maxCount){
                if(time[i]>maxTime){
                    maxTime=time[i];
                    maxTimeIndex=i;
                }
            }
        }
        printIntegers(count);
        return names[maxTimeIndex];
    }

    private String change(String str) {
        
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0; i<str.length()-1;i++){
            if(isA(str.charAt(i))){
                if(isA(str.charAt(i+1))){
                    list.add(str.charAt(i));
                }else{
                    if(str.charAt(i)=='A'){
                        list.add('I');

                    }else if(str.charAt(i)=='C'){
                        list.add('J');

                    }else if(str.charAt(i)=='D'){
                        list.add('K');

                    }else if(str.charAt(i)=='F'){
                        list.add('L');

                    }else if(str.charAt(i)=='G'){
                        list.add('H');

                    }
                }
            }else{
                continue;
            }
        }
        if(isA(str.charAt(str.length()-1))){
            list.add(str.charAt(str.length()-1));
        }
        String newStr="";
        for(char e:list) newStr+=e;
        return newStr;
    }

    private boolean isA(char c) {
        if((int)c>=65&&c<=90) return true;
        return false;
    }

    private void printIntegers(int[] arr) {
        for(int e:arr) System.out.print(e+" ");
        System.out.println();
    }

    private int getCount(int time, String str) {

        str = repeat(time,str);
        LinkedList<Integer> counts = new LinkedList<>();
        for(int i=0; i<=time-m.length(); i++){
            int count = check(str,i);
            if(count==m.length())
                counts.add(count);
        }
        
        int maxValue=0;
        for(int k=0;k<counts.size();k++){
            if(maxValue<counts.get(k)){
                maxValue=counts.get(k);
            }
        }
        return maxValue;
    }

    private int check(String str, int start) {
        int count=0;
        for(int i=0; i<m.length(); i++){
            if(m.charAt(i)==str.charAt(start+i)) count++;
        }

        return count;
    }

    private String repeat(int time, String str) {

        String real="";
        int j=0;
        for(int i=0;i<time;i++) {
            real+=str.charAt(j);
            j++;
            if(j==str.length()) j=0;
        }

        return real;
    }

    private int getTime(String time1, String time2) {
        int sum1,sum2=0;
        sum1= Integer.parseInt(time1.substring(0,2))*60+
            Integer.parseInt(time1.substring(3,5));
        sum2= Integer.parseInt(time2.substring(0,2))*60+
            Integer.parseInt(time2.substring(3,5));
        return sum2-sum1;
    }
}