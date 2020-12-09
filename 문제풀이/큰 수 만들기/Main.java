import java.util.ArrayList;
class Solution {

    String number;
    int k;
    boolean[] included;
    ArrayList<String> list;
    String max;

    public String solution(String number, int k) {
        this.number=number;
        this.k=k;
        included=new boolean[number.length()];
        // list=new ArrayList<>();
        max="0";

        combination(0,k);
        // String answer = getMax();
        return max;
    }

    private String getMax() {

        String max="0";
        for(int i=0; i<list.size(); i++){
            if(max.compareTo(list.get(i))<0) max=list.get(i);
        }
        return max;
    }

    private void combination(int index, int r) {

        if(r==0){
            String tmp = getNum();
            if(max.compareTo(tmp)<0) max=tmp;
            // list.add(getNum());
            return;
        }

        for(int i=index; i<number.length(); i++) {
            included[i] = true;
            combination(i + 1, r - 1);
            included[i] = false;
        }
    }

    private String getNum() {

        String sum="";
        for(int i=0; i<included.length; i++){
            if(!included[i]) sum+=number.charAt(i);
        }

        return sum;
    }

}