class Solution {
    int[] prices;
    public int[] solution(int[] prices) {
        this.prices=prices;
        int[] answer = new int[prices.length];


        for(int i=0; i<prices.length; i++){

            int start=i;
            int end=getEnd(start);

            if(end==prices.length){
                answer[i]=end-start-1;
            }else{
                answer[i]=end-start;
            }
        }
        return answer;
    }

    private int getEnd(int start) {

        int value=prices[start];
        int i;
        for(i=start+1; i<prices.length; i++){
            if(prices[i] < value) break;
        }
        return i;
    }
}