import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int i=4;
        while(i>=0){
            // int tmp = Integer.parseInt(sc.nextLine());
            int tmp = i;
            list.add(tmp);
            i--;
        }
        sc.close();
        sort(list,0,list.size());
        printInts(list);
    }

    private static void sort(ArrayList<Integer> list, int start, int end) {

        if(end-start>=2){
            int pivot = partition(list, start, end);
            sort(list, start, pivot);
            sort(list, pivot+1, end);
        }
    }

    private static int partition(ArrayList<Integer> list, int start, int end) {

        int pivot = list.get(end-1);
        int smallEnd=0, bigEnd=0;
        while(true){
            if(bigEnd==end-1) break;

            if(list.get(bigEnd)<pivot){
                swap(list, smallEnd, bigEnd);
                smallEnd++; bigEnd++;
            }else if(list.get(bigEnd)>pivot){
                bigEnd++;
            }
        }
        swap(list, smallEnd, end-1);

        return smallEnd;
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        int tmp=list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private static void printInts(ArrayList<Integer> list) {
        for(int n:list) System.out.println(n);
    }
}