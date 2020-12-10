import java.util.LinkedList;

class Solution {
    int[] priorities;
    int location;
    LinkedList<int[]> list;

    public int solution(int[] priorities, int location) {
        this.priorities=priorities;
        this.location=location;
        list=new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            int[] tmp = {priorities[i], i};
            list.add(tmp);
        }

        int count=0;
        while(true){
            int[] current=list.pollFirst();
            if(biggerExist(current)){
                list.add(current);
            }else{
                count++;
                if(current[1]==location) break;
            }
        }
        return count;
    }

    private boolean biggerExist(int[] current) {
        for(int[] arr:list){
            if(arr[0]>current[0]) return true;
        }
        return false;
    }
}