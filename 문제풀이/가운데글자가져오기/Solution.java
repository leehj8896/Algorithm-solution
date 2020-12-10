class Solution {
    public static String solution(String s) {
        String answer = "";

        int len = s.length();
        int i = 0;
        int j = len - 1;

        while (true) {
            if (i == j || i + 1 == j) {
                break;
            }
            i++;
            j--;
        }

        answer = s.substring(i, j + 1);

        return answer;
    }

    public static void main(String[] args) {
        String s = "qwer";
        System.out.println(solution(s));
    }
}