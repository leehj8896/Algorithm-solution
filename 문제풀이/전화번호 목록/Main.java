import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    String[] book;
    HashMap<String, Boolean> hashMap;

    public boolean solution(String[] phone_book) {
        book=phone_book;
        hashMap=new HashMap<>();

        // sort();
        register();
        boolean answer = search();
        
        return answer;
    }

    private boolean search() {

        boolean result = true;

        for(int i=0; i<book.length; i++){
            if(book[i].length()==2){
                if(hashMap.getOrDefault(book[i].substring(0,1), false)==true){
                    result=false;
                    break;
                }
            }
            for(int j=1; j<book[i].length()-1; j++){
                if(hashMap.getOrDefault(book[i].substring(0,j), false)==true){
                    result=false;
                    break;
                }
            }
        }
        return result;
    }

    private void register() {
        for(int i=0; i<book.length; i++){
            hashMap.put(book[i], true);
        }
    }

    private void sort() {
        Arrays.sort(book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
    }
}