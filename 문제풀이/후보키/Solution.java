import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static int solution(String[][] relation) {
        int answer = 0;
        Answer a = new Answer(relation);
        answer = a.getAnswer();
        return answer;
    }

    public static void main(String[] args) {
        String[][] relation = {
            {"100","ryan","music","2"},
            {"200","apeach","math","2"},
            {"300","tube","computer","3"},
            {"400","con","computer","4"},
            {"500","muzi","music","3"},
            {"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }
}
class Answer{

    String[][] relation;
    LinkedList<boolean[]> answers,minSet;
    int lenCol, lenLow;


    public Answer(String[][] relation) {
        this.relation=relation;
        answers = new LinkedList<>();
        minSet = new LinkedList<>();
        lenCol=relation[0].length;
        lenLow=relation.length;
    }

    public int getAnswer() {
    
        PowerSet p = new PowerSet(lenCol);
        answers = p.get(); 
        // boolean[] removeCheck = new boolean[answers.size()];
        for(int i=0; i<answers.size();) {
            // printBools(answers.get(i));
            if (!isUnique(answers.get(i))) {
                // System.out.println("\nnot unique");
                // removeCheck[i]=true;
                answers.remove(i);
            }else{            
                // System.out.println();
                // System.out.println("\nunique");
                i++;
            }
        }
        printBoolList(answers);
        getMinSet();
        return minSet.size();
    }

    private void getMinSet() {
        while(answers.size()>0){
            int minI = findMinI();
            boolean[] minE = answers.get(minI);
            minSet.add(minE);
            for(int i=0; i<answers.size();){
                boolean matched = true;
                for(int j=0; j<lenCol;j++){
                    if(minE[j]==true){
                        if(answers.get(i)[j]==false){
                            matched=false;
                        }
                    }
                }
                if(matched==true){
                    answers.remove(i);
                }else{
                    i++;
                }
            }
        }
    }

    private int findMinI() {

        int trueNum = lenCol+1;
        int index=-1;
        for(int i=0; i<answers.size();i++){
            int tmp = getTrueNum(answers.get(i));
            if(trueNum > tmp){
                trueNum=tmp;
                index=i;
            }
        }
        return index;
    }

    private int getTrueNum(boolean[] bs) {
        int num = 0;
        for(boolean b:bs){
            if(b==true)
                num++;
        }
        return num;
    }

    private boolean isUnique(boolean[] element) {
        // printBools(element);
        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String[] row:relation){
            String tmp="";
            for(int i=0; i<lenCol;i++){
                if(element[i]==true){
                    tmp+=row[i];
                }
            }
            // System.out.print(tmp+" ");
            int num = hashMap.getOrDefault(tmp, 0);
            if(num!=0){
                return false;
            }
            hashMap.put(tmp, 1);
        }
        return true;
    }

    private void printBoolList(LinkedList<boolean[]> list) {
        for(boolean[] e:list){
            printBools(e);
        }
    }

    private void printBools(boolean[] element) {
        for(boolean i:element)System.out.print(i+" ");
        System.out.println();
    }
}
class PowerSet{
    int len; 
    int[] arr;
    LinkedList<boolean[]> powerSet;
    boolean[] include;
    
    public PowerSet(int len) {
        this.len=len;
        arr=new int[len];   include=new boolean[len];
        for(int i=0;i<len;i++)arr[i]=i;
        powerSet=new LinkedList<>();
    }

    private void printBools(boolean[] include2) {
        for(Boolean e: include2)System.out.print(e+" ");System.out.println();
    }

    public LinkedList<boolean[]> get() {
        add(0);
        return powerSet;
    }

    private void add(int i) {
        if(i==len){
            boolean[] tmp = include.clone();
            powerSet.add(tmp);
        }else{
            include[i]=true;
            add(i+1);
            include[i]=false;
            add(i+1);
        }
    }
}