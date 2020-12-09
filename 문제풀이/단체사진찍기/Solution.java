class Solution {

    static char[] friends = {'A','C','F','J','M','N','R','T'};
    static int count;
    static int dataLength;
    static String[] data2;

    public static int abs(int num) {
        if (num < 0)
            return -num;
        return num;
    }

    // public static void printArr(int[] data) {
    //     for (int i = 0; i < data.length; i++) {
    //         System.out.print(data[i] + " ");
    //     }
    //     System.out.println();
    // }

    public static void perm(int i) {
        if (i == 8) {
            if (itsOK()) {
                count++;
            }
        } else {
            for (int j = i; j < 8; j++) {
                swap(i, j);
                perm(i + 1);
                swap(i, j);
            }
        }
    }

    public static boolean itsOK() {

        boolean result = true;

        for (int i = 0; i < dataLength; i++) {
            char first = data2[i].charAt(0);
            char second = data2[i].charAt(2);
            char condition = data2[i].charAt(3);
            int num = (int)(data2[i].charAt(4) - '0');
            
            int fIndex = findIndex(first);
            int sIndex = findIndex(second);
            int sub = abs(fIndex - sIndex) - 1;
            if (condition=='=') {
                if (!(sub == num)){
                    result = false;break;
                }
            } else if (condition == '<') {
                if (!(sub < num)){
                    result = false;break;}
            } else {
                if (!(sub > num)){
                    result = false;break;}
            }
        }
        return result;
    }

    public static int findIndex(char str) {

        int index=-1;
        for(int i=0;i < 8; i++) {
            if (friends[i]==str) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void swap(int i, int j) {
        char temp = friends[i];
        friends[i] = friends[j];
        friends[j] = temp;
    }

    public static int solution(int n, String[] data) {
        int answer = 0;
        dataLength = data.length;
        data2 = new String[dataLength];
        for(int i=0;i<dataLength;i++){
            data2[i]=data[i];
        }

        perm(0);
        
        answer = count;
        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };
        // String[] data = { "M~C<2", "C~M>1" };
        System.out.println(solution(n, data));
    }
}