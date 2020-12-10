import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) {
        try {
            InputStreamReader in=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(in);
            String[] nk=br.readLine().split(" ");
            int n=Integer.parseInt(nk[0]);
            int k=Integer.parseInt(nk[1]);
            int[] price=new int[n];

            for(int i=0; i<n; i++){
                price[i] = Integer.parseInt(br.readLine());
            }

            int count=0;
            for(int i=n-1; i>=0; i--){

                int qt=k/price[i];
                if(qt>0){
                    count+=qt;
                    k=k%price[i];
                }
            }
            
            System.out.println(count);

        } catch (Exception e) {
        }
    }
}