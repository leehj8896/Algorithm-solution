import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
            Table[] tables=new Table[n]; 
            for(int i=0; i<n; i++){
                String[] tmp=br.readLine().split(" ");
                Table t=new Table();
                t.start=Integer.parseInt(tmp[0]);
                t.end=Integer.parseInt(tmp[1]);
                tables[i]=t;
            }
            Arrays.sort(tables);

            int time=0, count=0;
            for(int i=0; i<n; i++){
                if(time<=tables[i].start && time<=tables[i].end){
                    count++;
                    time=tables[i].end;
                }
            }
            System.out.println(count);

            br.close();
        }catch(Exception e){
        }
    }
}
class Table implements Comparable<Table>{
    int start, end;

    @Override
    public int compareTo(Table t) {

        if(end<t.end){
            return -1;
        }else if(end>t.end){
            return 1;
        }else{
            if(start<t.start) return -1;
            else if(start>t.start) return 1;
        }
        return 0;
    }
}