import java.util.Arrays;

class Solution {

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int i = 0;  int sum = 0;
        while(true){
            sum += d[i];
            if(sum > budget){
                i--;
                break;
            }
            if(i == d.length-1)
                break;
            i++;
        }
        answer = i + 1;

        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        
        int budget = 9;
        System.out.println(solution(d,budget));
    }
}