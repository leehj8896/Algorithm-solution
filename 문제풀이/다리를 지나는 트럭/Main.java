import java.util.LinkedList;

class Solution {

    LinkedList<Integer> trucks, bridge;

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        setTrucks();
        bridge=new LinkedList<>();

        int truck=trucks.pollFirst();
        bridge.add(truck);
        int count = 1;

        while(bridge.size()>0){

            

        }


        int answer = 0;
        return answer;
    }
}