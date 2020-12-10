import java.util.Collection;
import java.util.HashMap;

class Solution {

    HashMap<String, Integer> hashMap;
    String[][] clothes;

    public int solution(String[][] clothes) {
        this.clothes=clothes;
        setHash();
        int count = getCount();

        return count;
    }

    private int getCount() {

        int sum=1;
        Collection<Integer> values=hashMap.values();
        for(int i:values){
            sum*=i+1;
        }
        return sum-1;
    }

    private void setHash() {
        hashMap=new HashMap<>();

        for(int i=0; i<clothes.length; i++){

            hashMap.put(clothes[i][1], 
                hashMap.getOrDefault(clothes[i][1], 0)+1
            );

        }

    }
}