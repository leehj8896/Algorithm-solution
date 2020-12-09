import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    
    public static void main(String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );
            int n=Integer.parseInt(br.readLine());
            int[] arr= new int[10001];
            for(int i=0; i<n; i++){
                int tmp = Integer.parseInt(br.readLine());
                arr[tmp]++;
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int i=1; i<10001; i++){
                for(int j=0; j<arr[i]; j++)
                    bw.write(i+"\n");
            }

            bw.close();
            // printInts(arr);
            
        } catch (Exception e) {
        }
        
    }
}