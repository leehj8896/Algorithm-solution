import java.util.Vector;

class Compress {

    static void printStrs(Vector<String> v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.elementAt(i));
        }
        System.out.println();
    }

    static int getMin(Vector<Integer> v) {
        int min = 99999;
        for (int i = 0; i < v.size(); i++) {
            if (min > v.elementAt(i))
                min = v.elementAt(i);
        }
        return min;
    }

    static int countText(Vector<String> v){
        int sum = 0;
        for(int i = 0; i < v.size(); i++){
            sum += v.elementAt(i).length();
        }
        return sum;
    }

    static int getLen(String text, int n) {

        Vector<String> v = new Vector<>();
        int blockNum = 1;
        int i = 0;  int len = text.length();
        while (true) {
            if(i+2*n > len){
                if(blockNum > 1){
                    v.add(blockNum+"");
                    v.add(text.substring(i, i+n));
                    if(i+n  <  len)
                        v.add(text.substring(i+n, len));
                }else{
                    v.add(text.substring(i, len));
                }
                break;
            }else if(text.substring(i, i+n).equals(text.substring(i+n, i+2*n))){
                blockNum++;
                i += n;
            }else{
                if(blockNum <= 1){
                    v.add(text.substring(i, i+n));
                    i+=n;
                } else {
                    v.add(blockNum + "");
                    v.add(text.substring(i, i + n));
                    i += n;
                    blockNum = 1;
                }
            }
        }
        printStrs(v);
        return countText(v);
    }

    public static void main(String[] args) {
        String text = "a";
        Vector<Integer> v = new Vector();
        for (int i = 1; i <= text.length() / 2 + 1; i++) {
            v.add(getLen(text, i));
        }
        System.out.printf("최소값: %d\n", getMin(v));
        System.out.println(v);

    }
}