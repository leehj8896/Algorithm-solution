import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    Node[] nodes;
    Tree tree;
    ArrayList<Integer> pre,post;

    public int[][] solution(int[][] nodeinfo) {
        
        setNodes(nodeinfo);
        Arrays.sort(nodes);
        setTree();

        pre=new ArrayList<>();
        post=new ArrayList<>();

        preorder(tree.root);
        postorder(tree.root);        

        int[][] answer = new int[2][];
        answer[0] = preToArr();  
        answer[1] = postToArr();        
        return answer;
    }

    private int[] preToArr() {
        int[] result=new int[pre.size()];
        for(int i=0; i<result.length; i++){
            result[i] = pre.get(i);
        }
        return result;
    }

    private int[] postToArr() {
        int[] result=new int[post.size()];
        for(int i=0; i<result.length; i++){
            result[i] = post.get(i);
        }
        return result;
    }

    private void postorder(Node current) {

        if(current.left!=null)
            postorder(current.left);
        if(current.right!=null)
            postorder(current.right);
        post.add(current.n);
    }

    private void preorder(Node current) {

        pre.add(current.n);
        if(current.left!=null)  
            preorder(current.left);
        if(current.right!=null)  
            preorder(current.right);        
    }

    private void setTree() {

        tree = new Tree(nodes[0]);
        for(int i=1; i<nodes.length; i++){
            tree.insert(nodes[i]);
        }
    }

    private void setNodes(int[][] nodeinfo) {
        
        nodes=new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            Node node = new Node();
            node.x=nodeinfo[i][0];
            node.y=nodeinfo[i][1];
            node.n=i+1;
            nodes[i]=node;
        }
    }
}

class Tree{
    Node root;

    public Tree(Node root) {
        this.root=root;
    }

    public void insert(Node node) {

        Node current = root;
        while(true){
            if(current.x < node.x){
                if(current.right==null){
                    current.right=node;
                    break;
                }else{
                    current=current.right;
                }
            }else{
                if(current.left==null){
                    current.left=node;
                    break;
                }else{
                    current=current.left;
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int x,y,n;
    Node left, right;

    public Node(){
        x=-1;   
        y=-1;   
        n=-1;
    }

    @Override
    public int compareTo(Node node) {
        return node.y-this.y;
    }
}