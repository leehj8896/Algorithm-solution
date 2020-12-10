class Main{
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] numbers={1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(s.solution(numbers, target));
    }
}

class Solution {
    int[] numbers;
    int target,count;
    
    public int solution(int[] numbers, int target) {
        this.numbers=numbers; this.target=target;
        count=0;

        countTarget(0);

        return count;
    }

    private void countTarget(int i) {

        if(i<numbers.length){
            countTarget(i+1);
            numbers[i]*=-1;
            countTarget(i+1);

        }else if(i==numbers.length){
            if(sum(numbers)==target)  count++;
        }

    }

    private int sum(int[] arr) {
        int result=0;
        for(int i:arr) result+=i;
        return result;
    }
}