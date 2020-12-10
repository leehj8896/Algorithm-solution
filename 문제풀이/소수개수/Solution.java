class Solution {
    public static int solution(int n) {
        int answer = 0;
        Answer a = new Answer(n);
        answer = a.get();
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }
}
class Answer{
    int n;
    boolean[] list;

    public Answer(int n) {
        this.n=n;
        list = new boolean[n+1];
    }

    public int get() {
        int count=0;
        for(int i=2; i<=n; i++){
            if(list[i]==false){
                // System.out.println(i);
                count++;
                int j=i; 
                int x=1;
                while(j*x<=n){
                    list[j*x]=true;
                    x++;
                }
            }
        }
        // printBools(list);
        return count;
    }

    private void printBools(boolean[] list2) {
        for(boolean e:list2)System.out.print(e+" ");
        System.out.println();
    }
}