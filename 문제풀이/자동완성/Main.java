import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public int solution(String[] words) {
        Arrays.sort(words);
        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }

        int sum=0;
        for(String word:words){
            int count = trie.getCount(word);
            sum+=count;
        }
        return sum;
    }
}


class Trie{
    Node root;

    public Trie(){
        root = new Node();
    }

    public int getCount(String word) {

        Node current = root;
        int count=0;
        for(int i=0; i<word.length(); i++){
            count++;
            int k=in(current.nodes, word.charAt(i));
            current=current.nodes.get(k);
            if(current.isEnd||current.count==1){
                if(current.isEnd) current.isEnd=false;
                break;
            } 
        }

        return count;
    }

    public void insert(String word) {

        Node current = root;
        current.count++;
        for(int i=0; i<word.length(); i++){
            int k=in(current.nodes, word.charAt(i));
            if(k>=0){
                current=current.nodes.get(k);
                current.count++;
            }else{
                Node n = new Node();
                n.c=word.charAt(i);
                n.count++;
                current.nodes.add(n);
                current=n;
            }
        }
        current.isEnd=true;
    }

    private int in(ArrayList<Node> nodes, char c) {
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).c==c) return i;
        }
        return -1;
    }
}

class Node{
    char c;
    int count;
    boolean isEnd;
    ArrayList<Node> nodes;

    public Node(){
        c=' ';
        count=0;
        isEnd=false;
        nodes=new ArrayList<>();
    }
}