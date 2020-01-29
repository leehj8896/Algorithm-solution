class Solution {
    public static String solution(String s) {
        String answer = "";
        Answer a = new Answer(s);
        answer = a.get(0,s.length()-1);
        return answer;
    }

    public static void main(String[] args) {
        String s="qwer";
        System.out.println(solution(s));
    }
}

class Answer {
    String s;

    public Answer(String s) {
        this.s = s;
    }

    public String get(int start, int end) {
        if(start == end){
            return s.substring(start,start+1);
        }else if(start+1==end){
            return s.substring(start,end+1);
        }else{
            return get(start+1,end-1);
        }
    }
}