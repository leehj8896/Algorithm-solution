import java.util.*;

public class Solution {
	public static int[] solution(int []arr) {
       
        List<Integer> temp = new ArrayList<Integer>();

        temp.add(arr[0]);
        int i = 1;  int len= arr.length;
        for(;i<len;i++){
            if(arr[i-1] != arr[i])
                temp.add(arr[i]);
        }

        int llll=temp.size();
        int[] answer = new int[llll];
        for(int j=0;j<llll;j++)
            answer[j]=temp.get(j);

        return answer;
    }
    
    public static void main(String[] args) {
        int[] arr1={1,1,3,3,0,1,1};
        int[] arr2={4,4,4,3,3};
        printArr(solution(arr1));
        printArr(solution(arr2));
    }

    static void printArr(int[] arr){
        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();
    }
}