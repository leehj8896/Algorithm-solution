import java.util.LinkedList;

class Solution {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Answer a = new Answer(cacheSize, cities);
        answer=a.get();
        return answer;
    }public static void main(String[] args) {
        int n=3;
        String[] s={"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(n,s));
    }
}

class Answer {
    int cacheSize,time;
    String[] cities;
    LinkedList<String> list;
    public Answer(int cacheSize, String[] cities){
        this.cacheSize=cacheSize;
        this.cities=cities;
        time=0;
        list=new LinkedList<>();
    }

    public int get() {

        for(int i=0;i<cities.length;i++){
            int index=inList(cities[i]);
            if(index>=0){
                list.remove(index);
                list.add(cities[i].toLowerCase());
                time+=1;
            }else{
                list.add(cities[i].toLowerCase());
                if(list.size()>cacheSize){
                    list.removeFirst();
                }
                time+=5;
            }
        }

        return time;
    }

    private int inList(String str) {
        int index=-1;
        for(int i=0; i<list.size();i++){
            if(str.toLowerCase().equals(list.get(i).toLowerCase())){
                index=i;
                break;
            }
        }
        return index;
    }
}