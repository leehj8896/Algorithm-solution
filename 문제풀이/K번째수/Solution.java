class Solution {

    static int partition(int[] arr, int start, int end){

        //printArr(arr, start, end);
        int pivotValue = arr[end];
        int[] small = new int[end-start]; int j = 0;
        int[] big = new int[end-start];   int k = 0;

        //System.out.printf("len=%d\n",end-start+1);
        for(int i = start; i < end; i++){
            if(arr[i] > pivotValue){
                big[k++]=arr[i];
            }else{
                small[j++]=arr[i];
            }
        }
        int smallLen = j;   int bigLen = k;

        j=0; int i;
        for(i = start; i < start+smallLen; i++){
            arr[i] = small[j++];
        }
        arr[i] = pivotValue; int pivotIndex = i++;
        k=0;
        for(;i<=end;i++){
            arr[i]=big[k++];
        }

        return pivotIndex;
    }

    public static void sort(int[] arr, int start, int end){
        if(start < end){
            int pivot = partition(arr, start, end);
            sort(arr, start, pivot-1);
            sort(arr, pivot+1, end);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {

        int len = commands.length;
        int arrlen=array.length;
        int[] answer = new int[len];

        for(int i = 0; i<len; i++){
            int[] temp = new int[arrlen];
            for(int j = 0; j < arrlen; j++){
                temp[j] = array[j];
            }
            sort(temp, commands[i][0]-1, commands[i][1]-1);
            answer[i] = temp[commands[i][0]+commands[i][2] -2];
            //printArr(temp, 0, 6);
        }

        return answer;
    }

    public static void main(String[] args){
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {
            {2,5,3},
            {4,4,1},
            {1,7,3}
        };
        printArr(solution(array, commands), 0,2);
    }

    public static void printArr(int[] arr, int start, int end){
        for(int i = start; i <= end; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}