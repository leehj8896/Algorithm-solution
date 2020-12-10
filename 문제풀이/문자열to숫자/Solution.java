class Solution {
  public static int solution(String s) {
      int answer = 0;
      Answer a=new Answer(s);
      answer = a.get();
      return answer;
  }
  public static void main(String[] args) {
      String s="-1234";
      System.out.println(solution(s));
  }
}
class Answer{
    String s;
    public Answer(String s) {this.s=s;
    }

    public int get() {
        if(s.substring(0,1).equals("+")){
            return Integer.parseInt(s.substring(1,s.length()));
        }else if(s.substring(0,1).equals("-")){
            return -Integer.parseInt(s.substring(1,s.length()));
        }else{
            return Integer.parseInt(s.substring(0,s.length()));
        }
    }
    
}