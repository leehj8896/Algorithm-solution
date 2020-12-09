import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int[][][] map;
    int n;

    public int[][] solution(int n, int[][] build_frame) {
        this.n=n;
        mapInit();

        for(int i=0; i<build_frame.length; i++){

            int x=build_frame[i][0];
            int y=build_frame[i][1];
            int type=build_frame[i][2];
            int action=build_frame[i][3];

            //설치일때
            if(action==1){
                map[y][x][type]++;
                if(check(x,y)==false){
                    map[y][x][type]--;
                }
            }
            //삭제일때
            else if(action==0){
                if(map[y][x][type]>0){
                    map[y][x][type]--;
                    //기둥일때
                    if(type==0){
                        if(check(x-1,y+1)==false || check(x,y+1)==false){
                            map[y][x][type]++;
                        }
                    }
                    //보일때
                    else if(type==1){
                        if(check(x-1,y)==false || check(x,y)==false || check(x+1,y)==false){
                            map[y][x][type]++;
                        }
                    }
                }
            }
        }

        int[][] result = getResult();
        Arrays.sort(result, (o1,o2)->{
            if(o1[0]==o2[0]){
                if(o1[1]==o2[1]){
                    return Integer.compare(o1[2], o2[2]);
                }else{
                    return Integer.compare(o1[1], o2[1]);
                }
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        print(result);
        return result;
    }

    private boolean check(int x, int y) {

        boolean result=true;

        //기둥체크
        if(map[y][x][0]==1){
            if(
                y==0||
                (y-1>=0 && map[y-1][x][0]==1)||
                (x-1>=0 && map[y][x-1][1]==1)||
                (x+1<n+1 && map[y][x+1][1]==1)
            ){
                result=true;
            }else{
                return false;
            }
        }
        //보체크
        if(map[y][x][1]==1){
            if(
                (y-1>=0 && map[y-1][x][0]==1)||
                (y-1>=0 && x+1<n+1 && map[y-1][x+1][0]==1)||
                (x-1>=0 && x+1<n+1 && map[y][x-1][1]==1 && map[y][x+1][1]==1)
            ){
                result=true;
            }else{
                return false;
            }
        }

        return result;
    }

    private void mapInit() {

        map = new int[n+1][n+1][2];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){
                map[i][j]=new int[2];
            }
        }
    }

    private void print(int[][] arr) {
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private int[][] getResult() {

        ArrayList<int[]> result = new ArrayList<>();

        for(int i=0; i<n+1; i++){
            for(int j=0; j<n+1; j++){

                if(map[i][j][0]==1){
                    int[] tmp=new int[3];
                    tmp[0]=j;
                    tmp[1]=i;
                    tmp[2]=0;
                    result.add(tmp);
                }
                if(map[i][j][1]==1){
                    int[] tmp=new int[3];
                    tmp[0]=j;
                    tmp[1]=i;
                    tmp[2]=1;
                    result.add(tmp);
                }
            }
        }
        return listToArr(result);
    }

    private int[][] listToArr(ArrayList<int[]> list) {

        int[][] result = new int[list.size()][];

        for(int i=0; i<list.size(); i++){
            result[i]=list.get(i);
        }

        return result;
    }
}