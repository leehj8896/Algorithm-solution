class Solution {

    static void share(int[] student, int n, int index) {
        if (index >= 1 && index <= n) {
            if (student[index] == 2) {
                if (student[index - 1] == 0) {
                    student[index - 1]++;
                    student[index]--;
                } else if (student[index + 1] == 0) {
                    student[index + 1]++;
                    student[index]--;
                }
            }
            share(student, n, index + 1);
        }
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        // 초기화
        int[] students = new int[n + 2];
        for (int i = 0; i <= n + 1; i++)
            students[i] = 1;
        students[0] = -1;
        students[n + 1] = -1;
        // lost
        for (int l : lost)
            students[l]--;
        // reserve
        for (int r : reserve)
            students[r]++;

        share(students, n, 1);

        for (int student : students) {
            if (student >= 1)
                answer++;
        }
        return answer;
    }

    static void printArr(int[] arr) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 6;
        int[] lost = { 2, 4 };
        int[] reserve = { 1, 3 };
        System.out.println(solution(n, lost, reserve));
    }
}