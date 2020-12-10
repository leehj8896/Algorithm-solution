import java.util.HashMap;

class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = {};
        Answer a = new Answer(n, words);
        answer = a.get();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
        printPair(solution(n, words));
    }

    private static void printPair(int[] solution) {
        System.out.println(solution[0] + " " + solution[1]);
    }
}

class Answer {
    int n;
    String[] words;
    HashMap<String, Boolean> hashMap;
    int[] answer;

    public Answer(int n, String[] words) {
        this.n = n;
        this.words = words;
        hashMap = new HashMap<>();
        answer = new int[2];answer[0]=0;answer[1]=0;
    }

    public int[] get() {

        int count = 0;
        for (int i = 0; i < words.length; i++) {

            count = i/n+1;

            boolean tmp = hashMap.getOrDefault(words[i], false);
            if (tmp == false) {
                hashMap.put(words[i], true);
            } else {
                answer[0] = (i) % n + 1;
                answer[1] = count;
                return answer;
            }
            if (i > 0) {
                if (!words[i-1].substring(words[i-1].length()-1, words[i-1].length()).equals(
                    words[i].substring(0, 1))) {
                    answer[0] = (i) % n + 1;
                    answer[1] = count;
                    return answer;
                }
            }
            if(words[i].length()==1){
                answer[0] = (i) % n + 1;
                answer[1] = count;return answer;
            }
        }

        return answer;
    }

}