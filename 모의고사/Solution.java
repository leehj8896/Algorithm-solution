import java.util.ArrayList;

class Solution {

    public static int grade(int[] answers, int[] student){
        int answerIndex = 0;
        int studentIndex= 0;
        int score = 0;
        while(answerIndex < answers.length){
            
            if(answers[answerIndex] == student[studentIndex]){                
                score++;
            }
            studentIndex++;
            if(studentIndex >= student.length){
                studentIndex = 0;
            }            
            answerIndex++;
        }
        return score;
    }

    public static int max(int[] arr){
        int max = -1;
        for(int v:arr){
            if(v > max)
                max=v;
        }
        return max;
    }

    public static int[] solution(int[] answers) {
        
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};

        int[] scores = {0,0,0}; 
        scores[0] = grade(answers, st1);
        scores[1] = grade(answers, st2);
        scores[2] = grade(answers, st3);
        int maxValue = max(scores);
        int len = 0;
        for(int score: scores){
            if(score == maxValue)
                len++;
        }
        int j = 0;
        int[] answer = new int[len];
        for(int i=0;i<3;i++){
            if(scores[i] == maxValue){
                answer[j]=i+1;
                j++;
            }
        }

        return answer;
    }

    public static void printArr(int[] scores){
        for(int score : scores)
            System.out.print(score);
        System.out.println();
    }

    public static void main(String[] args) {
        int answer1[] = { 1, 2, 3, 4, 5 };
        int answer2[] = { 1, 3, 2, 4, 2 };
        printArr(solution(answer1));
        printArr(solution(answer2));
    }
}