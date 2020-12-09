import java.util.PriorityQueue;

class Solution {

    public int solution(int[] scoville, int K) {

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            priorityQueue.add((long)scoville[i]);
        }

        int count=0;
        while(true){
            
            long f=priorityQueue.poll();
            if(f>=K) return count;

            if(priorityQueue.size()==0){
                if(f<K){
                    return -1;
                } 
            }else{
                long s=priorityQueue.poll();
                priorityQueue.add(f+2*s);
                count++;
            }
        }
    }
}