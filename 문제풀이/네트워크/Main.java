class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Answer a=new Answer(n, computers);
        answer=a.get();
        return answer;
    }
}

class Answer{
    int n,count;
    int[][] computers;
    boolean[] checked;

    public Answer(int n, int[][] computers) {
        this.n=n; this.computers=computers;
        checked=new boolean[n];
        count=0;
    }

    public int get() {
        for(int i=0; i<n; i++){
            if(checked[i]==false){
                traversal(i);
                count++;
            }
        }
        return count;
    }

    private void traversal(int start) {
        checked[start]=true;
        for(int i=0; i<n; i++){
            if(computers[start][i]==1){
                if(checked[i]==false) traversal(i);
            }
        }
    }
}