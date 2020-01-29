class Solution {
    public static String solution(int n) {
        String answer = "";
        Answer a=new Answer(n);
        answer=a.get();
        return answer;
    }public static void main(String[] args) {
        int n=3;
        System.out.println(solution(n));
    }
  }

class Answer {
    int n;  String result;
    public Answer(int n) {this.n=n; result="";
    }

    public String get(String result) {
        if((n-1)/3==0){
            if((n-1)%3==0)
                return result+"1";
            if((n-1)%3==0)
                return result+"2";
            if((n-1)%3==0)
                return result+"4";
        }        
    }

}