import java.util.Arrays;

class Solution {

    public String solution(int[] numbers) {
        NewNum[] nums = new NewNum[numbers.length];
        for(int i=0; i<numbers.length; i++) nums[i]=new NewNum(numbers[i]);
        Arrays.sort(nums);

        return toStr(nums);
    }

    private String toStr(NewNum[] nums) {
        String sum=""; int zeroCount=0;
        for(NewNum n:nums) {
            if(Integer.parseInt(n.num1)!=0) zeroCount++;
            sum+=n.num1;
        }        
        if(zeroCount>0) return sum;
        return "0";
    }
}

class NewNum implements Comparable<NewNum>{
    String num1;
    public NewNum(int i) { num1=i+""; }

    @Override
    public int compareTo(NewNum num2) {
        String tmp1=num1+num2.num1;
        String tmp2=num2.num1+num1;
        return -tmp1.compareTo(tmp2);
    }
}