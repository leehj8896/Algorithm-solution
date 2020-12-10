import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        
        Trie[] tries=new Trie[10001];
        for(int i=1;i<10000; i++) tries[i]=new Trie();
        Trie[] rts=new Trie[10001];
        for(int i=1;i<10000; i++) rts[i]=new Trie();

        for(int i=0; i<words.length; i++){
            int len = words[i].length();
            tries[len].insert(words[i]);
            words[i]= (new StringBuffer(words[i])).reverse().toString();
            rts[len].insert(words[i]);
        }

        int[] answer = new int[queries.length];
        HashMap<String, Integer> hashMap=new HashMap<>();
        for(int i=0; i<queries.length; i++){

            int count=hashMap.getOrDefault(queries[i], -1);
            if(count==-1){
                int len=queries[i].length();
                if(queries[i].charAt(0)=='?'){
                    queries[i]= (new StringBuffer(queries[i])).reverse().toString();
                    count=getCount(rts, len, queries[i]);
                }else{
                    count=getCount(tries, len, queries[i]);
                }    
            }
            answer[i]=count;                
        }

        return answer;
    }

    private int getCount(Trie[] tries, int len, String word) {

        Node current=tries[len].root;
        for(int i=0; i<word.length(); i++){
            // System.out.println(word.charAt(i));
            if(word.charAt(i)=='?'){
                return current.count;
            }else{
                int k=has(current.children, word.charAt(i));
                if(k==-1) return 0;    
                current=current.children.get(k);
            }
        }

        return 0;
    }

    private int has(ArrayList<Node> children, char c) {
        
        for(int i=0; i<children.size(); i++){
            if(children.get(i).data==c) return i;
        }
        return -1;
    }
}

class Node{
    char data;
    ArrayList<Node> children;
    boolean isLast;
    int count=0;

    public Node(){
        count=0;
        data=' ';
        isLast=false;
        children=new ArrayList<>();
    }
}

class Trie{
    Node root;
    
    public Trie(){
        root = new Node();
    }

    void insert(String word) {

        Node current=root;
        current.count++;
        for(int i=0; i<word.length(); i++){

            int k=has(current.children, word.charAt(i));
            if(k==-1){
                Node child=new Node();
                child.data=word.charAt(i);
                child.count++;
                current.children.add(child);
                current=current.children.get(current.children.size()-1);
            }else{
                current=current.children.get(k);
                current.count++;
            }
        }
        current.isLast=true;
    }

    private int has(ArrayList<Node> children, char c) {
            
        for(int i=0; i<children.size(); i++){
            if(children.get(i).data==c) return i;
        }
        return -1;
    }
}