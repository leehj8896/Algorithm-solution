import java.util.Arrays;

class Solution {
    int n,t,m;
    String[] timetable;
    Bus[] buses;

    public String solution(int n, int t, int m, String[] timetable) {
        this.n=n; this.t=t; this.m=m; this.timetable=timetable;
        
        Arrays.sort(timetable);
        busArrInit();
        int people;
        if(n-2>=0){
            people=buses[n-1].end - buses[n-2].end;
        }else{
            people=buses[n-1].end;
        }
        if(people<m)
            return buses[n-1].time;
            
        return getTime(buses[n-1]);
    }

    private void busArrInit() {
        
        String time="09:00";
        int k=-1;


        for(int i=0; i<timetable.length; i++){
            if(timetable[i].compareTo(time)>0){
                k=i;
                break;
            }
        }
        time=nextTime(time, t);
        i=k;

    }

    private String getTime(Bus b) {

        String target = timetable[b.start+m-1];
        String[] hm=target.split(":");
        int sum= Integer.parseInt(hm[0])*60+Integer.parseInt(hm[1]);

        return sum/60+""+sum%60;
    }
}

class Bus{
    int end;
    String time;

    Bus(){
        end=-1;
        time=null;
    }
}