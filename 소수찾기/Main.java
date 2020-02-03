import java.util.HashMap;
import java.util.LinkedList;

// class Main {
//     public static void main(String[] args) {
//         String numbers="17";
//         Solution s= new Solution();
//         System.out.println(s.solution(numbers));
//     }
// }

class Solution {
    String numbers;
    boolean[] include;
    HashMap<Integer, Boolean> hashMap;

    public int solution(String numbers) {
        this.numbers=numbers;
        include=new boolean[numbers.length()];
        hashMap = new HashMap<>();
        powerset(0);

        return hashMap.size();
    }

    private void powerset(int i) {

        if(i<numbers.length()){
            include[i]=false;
            powerset(i+1);
            include[i]=true;
            powerset(i+1);
        }else{
            if(allNotFalse()){
                LinkedList<String> tmp = getSum();
                // System.out.println(tmp);
                Perm p = new Perm(tmp, hashMap);
                p.run();
                // System.out.println();
            }
        }
    }

    private boolean allNotFalse() {
        for(int i=0; i<include.length; i++){
            if(include[i]==true) return true;
        }
        return false;
    }

    private boolean isPrime(int num) {
        if(num==1) return false;
        for(int i=2; i<=num-1; i++){
            if(num%i==0) return false;
        }
        return true;
    }

    private LinkedList<String> getSum() {
        LinkedList<String> list = new LinkedList<>();
        for(int i=0; i<numbers.length(); i++){
            if(include[i]==true) list.add(numbers.substring(i,i+1));
        }
        
        return list;
    }
}
class Perm{
    LinkedList<String> list;
    HashMap<Integer, Boolean> hashMap;
    
    public Perm(LinkedList<String> tmp, HashMap<Integer, Boolean> hashMap) {
        list=tmp; this.hashMap=hashMap;
        // System.out.println(tmp);
    }

    public void run() {
        perm(0);
    }

    private void perm(int i) {
        if(i<list.size()){
            for(int j=i; j<list.size(); j++){
                swap(i,j);
                perm(i+1);
                swap(i,j);
            }
        }else{
            int key = getKey();
            // System.out.print(key+" ");
            if(isPrime(key)) {
                hashMap.put(key, true);
                // System.out.println(key);
            }
        }
    }

    private int getKey() {
        String sum = "";
        for(String e:list) sum+=e;
        // System.out.print(sum+" ");
        return Integer.parseInt(sum);
    }

    private void swap(int i, int j) {
        String tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private boolean isPrime(int num) {
        if(num<=1) return false;
        for(int i=2; i<=num-1; i++){
            if(num%i==0) return false;
        }
        return true;
    }
}