class Solution {

    public static int[] solution(int N, int[] stages) {
        int[] answer = {};

        int[] c = new int[N+1];   //수행중인사람수
        int[] p = new int[N+1];   //도달한사람수
        for(int i = 0; i < N+1; i++){
            c[i] = 0;   p[i] = 0;
        }

        int M = stages.length;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N+1; j++){
                //수행중
                if(j+1 == stages[i]){
                    c[j]++;
                    p[j]++;
                //지나감
                }else if(j+1 < stages[i]){
                    p[j]++;
                }
            }
        }

        float[] r = new float[N];
        for(int i = 0; i < N; i++){
            if(p[i] == 0){
                r[i] = 0;
            }else{
                r[i] = (float)c[i]/p[i];
            }
        }
        
        int[] index = new int[N];
        for(int i = 0; i < N;i++){
            index[i] = i+1;
        }

        printArr(r);

        //ms(r,index,0,N-1);
        qs(r,index,0,N-1);
        //printArr(r);

        return index;
    }


    private static void qs(float[] value, int[] index, int start, int end) {
        if(start<end){
            int pivot=partition(value, index, start, end);
            qs(value, index, start, pivot-1);
            qs(value, index, pivot+1, end);
        }
    }

    private static int partition(float[] value, int[] index, int start, int end){
        
        int pivot;
        int len = end-start+1;
        float[] sorted = new float[len];
        int[] sortedIndex = new int[len];

        int i = start;
        int j = 0;
        //큰것만복사
        while(i<=end-1){
            if(value[end] <= value[i]){
                sorted[j] = value[i];
                sortedIndex[j]=index[i];
                j++;
            }
            i++;
        }
        System.out.println("큰거개수=" + j);
        //피벗복사
        sorted[j] = value[end];
        sortedIndex[j]=index[end];
        pivot = start + j;
        j++;
        
        //작은것복사
        i = start;
        while(i<=end-1){
            if(value[end] > value[i]){
                sorted[j] = value[i];
                sortedIndex[j]=index[i];
                j++;
            }
            i++;
        }
        //전체복사
        i=start;    j = 0;
        while(i<=end){
            value[i]=sorted[j];
            index[i]=sortedIndex[j];
            i++;    j++;
        }
        System.out.println("pivot=" + pivot);
        return pivot;
    }

    private static void printArr(int[] index) {
        for(int i = 0; i < index.length; i++){
            System.out.print(index[i] + " ");
        }
        System.out.println();
    }

    private static void printArr(float[] r) {
        for(int i = 0; i < r.length; i++){
            System.out.print(r[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        //int N = 5;
        int N = 4;
        //int[] stages = {2,1,2,6,2,4,3,3};
        int[] stages = {4,4,4,4,4};
        printArr(solution(N,stages));
    }
}