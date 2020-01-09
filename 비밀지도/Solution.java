class Solution{

    public static int[] bbbb(int n, int time){
        int arr[] = new int[time];

        for(int i = 0; i < time; i++){
            if(n%2 == 1){
                arr[time-i-1] = 1;
            }else{
                arr[time-i-1] = 0;
            }
            n = n / 2;
        }
        return arr;
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            int first[] = bbbb(arr1[i], n);
            int second[] = bbbb(arr2[i], n);
            String sum = "";
            for(int j = 0; j < n; j++){
                if(first[j] == 0 && second[j] == 0){
                    sum += " ";
                }else{
                    sum += "#";
                }
            }
            answer[i] = sum;
            System.out.println(sum);
        }
        //System.out.println(answer);
        return answer;
    }

    public static void main(String args[]) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(solution(n, arr1, arr2));
    }
}