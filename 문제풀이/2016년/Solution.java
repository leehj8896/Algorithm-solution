class Solution {
    public static String solution(int a, int b) {
        String answer = "";

        int[] d = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int sum = 0;

        for (int i = 0; i <= a - 2; i++) {
            sum += d[i];
        }
        sum += b;
        int x = sum%7;

        if(x==0){
            answer="THU";
        }else if(x==1){
            answer="FRI";
        }else if(x==2){
            answer="SAT";
        }else if(x==3){
            answer="SUN";
        }else if(x==4){
            answer="MON";
        }else if(x==5){
            answer="TUE";
        }else if(x==6){
            answer="WED";
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }
}