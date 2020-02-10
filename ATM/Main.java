import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
            String[] tmp=br.readLine().split(" ");
            int[] p=new int[n];
            for(int i=0; i<n; i++) p[i]=Integer.parseInt(tmp[i]);
            Arrays.sort(p);

            int sum=0;
            for(int i=0; i<n; i++){
                sum+=p[i] * (n-i);
            }

            System.out.println(sum);

        } catch (Exception e) {
        }
    }
}