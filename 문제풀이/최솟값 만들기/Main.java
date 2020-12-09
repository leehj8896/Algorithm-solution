import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);

        Integer[] newb = new Integer[B.length];
        for(int i=0; i<newb.length; i++){
            newb[i]=new Integer(B[i]);
        }


        Arrays.sort(newb, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int sum=0;
        for(int i=0; i<newb.length; i++){
            sum+=A[i]*newb[i];
        }


        return sum;
    }
}