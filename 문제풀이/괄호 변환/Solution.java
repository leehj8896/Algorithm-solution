import java.util.Stack;

class Solution {

    //start에서 시작하는 가장 작은 균형
    static int getUEnd(String p, int start){
        int leftCount = 0;
        int rightCount = 0;
        int len = p.length();
        int i = start;
        while(i<len){
            
            if(p.substring(i, i+1).equals("(")){
                leftCount++;
            }else if(p.substring(i, i+1).equals(")")){
                rightCount++;
            }
            
            if(leftCount >= 1 && rightCount >= 1){
                if(leftCount == rightCount){
                    break;
                }
            }
            i++;
        }
        return i;
    }

    static String generate(String str){
        int len = str.length();
        String result = "";

        for(int i = 1; i < len-1; i++){
            if(str.substring(i, i+1).equals("("))
                result += ")";
            else if(str.substring(i, i+1).equals(")"))
                result += "(";
        }
        return result;
    }

    static boolean isRight(String str){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(str.substring(i,i+1).equals("(")){
                stack.push(str.substring(i,i+1));
            }else if(str.substring(i,i+1).equals(")")){

                String temp = "";
                if(stack.size() > 0){
                    temp = stack.pop();
                    if(temp.equals("(")){
        
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.size() >= 1){
            return false;
        }
        return true;
    }

    static String bToR(String p, int start, int end){

        if(p.substring(start, end+1).equals("")){
            return "";
        }else{

            int uEnd = getUEnd(p, start);
            if(isRight(p.substring(start, uEnd+1))){
                return p.substring(start, uEnd+1) + bToR(p, uEnd+1, end);
            }else{
                return "(" + bToR(p, uEnd+1, end) + ")" + generate(p.substring(start, uEnd+1));
            }
        }
    }

    public static String solution(String p) {
        String answer = "";

        answer = bToR(p, 0, p.length()-1);

        return answer;
    }

    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";
        System.out.println(solution(p1));
        System.out.println(solution(p2));
        System.out.println(solution(p3));
    }
}