import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    static int check(int m, int n, int[][] picture, int[][] checked, int value, int i, int j) {

        if (0 <= i && i < m && 0 <= j && j < n) {
            if (checked[i][j] == 0) {
                if (picture[i][j] == value) {
                    checked[i][j]++;
                    return 1 + check(m, n, picture, checked, value, i - 1, j)
                            + check(m, n, picture, checked, value, i, j - 1)
                            + check(m, n, picture, checked, value, i + 1, j)
                            + check(m, n, picture, checked, value, i, j + 1);

                } else {

                }
            } else {

            }
        } else {

        }

        return 0;
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[][] checked = new int[m][n];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checked[i][j] == 0 && picture[i][j] != 0) {
                    int size = check(m, n, picture, checked, picture[i][j], i, j);
                    list.add(size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = list.size();
        answer[1] = Collections.max(list);
        return answer;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };
        int[] answer = solution(m, n, picture);
        System.out.println(answer[0] + " " + answer[1]);
    }
}