class Main{
    public static void main(String[] args) {
        int n=16;
        int t=16;
        int m=2;
        int p=1;
        Solution s= new Solution();
        System.out.println(s.solution(n, t, m, p));
    }
}
class Solution {
    int n,t,m,p;
    String total,my;

    public String solution(int n, int t, int m, int p) {
        this.m=m;this.t=t;this.n=n;this.p=p;
        String my = ""; String total="";

        int num=0;
        while(true){
            if(my.length()>=t) break;
            total += change(num);
            System.out.println(change(num));
            while(true){
                // System.out.println("test");
                if(my.length()*m+p-1>total.length()-1) break;
                my+=total.charAt(my.length()*m+p-1);
            }
            num++;
        }
        return my.substring(0, t);
    }

    // num을 n진수로 바꾼후 String return
    public String change(int num) {
        String sum="";
        
        while(true){
            int mok=num/n;
            int na=num%n;
            if(na==10){
                sum="A"+sum;
            }else if(na==11){
                sum="B"+sum;
            }else if(na==12){
                sum="C"+sum;
            }else if(na==13){
                sum="D"+sum;
            }else if(na==14){
                sum="E"+sum;
            }else if(na==15){
                sum="F"+sum;
            }else{
                sum=na+sum;
            }
            num=mok;
            if(num==0) break;
        }
        return sum;
    }
}