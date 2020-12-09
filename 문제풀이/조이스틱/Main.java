class Main{
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(
            s.solution("JEROEN")
        );
    }
}
class Solution {

    int[] gaps;

    public int solution(String name) {
        gaps=new int[name.length()];

        for(int i=0; i<name.length(); i++){
            gaps[i]=min(
                (int)name.charAt(i)-(int)'A',
                (int)'Z'-(int)name.charAt(i)+1
            );
        }

        // int sum=getSum();

        int sum=0;
        int idx=0;
        while(true){
            // System.out.println(idx+" "+gaps[idx]);
            // System.out.println(9+4+9+12+4+13);
            sum+=gaps[idx];
            gaps[idx]=0;

            if(all0()) break;
            
            int right=1;
            int left=1;

            for(int i=1; i<gaps.length; i++){
                int tmp=idx+i;
                if(tmp>gaps.length-1) tmp-=gaps.length;
                if(gaps[tmp]==0){
                    right++;
                }else{
                    break;
                }
            }
            for(int i=1; i<gaps.length; i++){
                int tmp=idx-i;
                if(tmp<0) tmp+=gaps.length;
                if(gaps[tmp]==0){
                    left++;
                }else{
                    break;
                }
            }
            // System.out.println(left+" "+right);
            if(right>left){
                sum+=left;
                idx-=left;
                if(idx<0) idx+=gaps.length;
            }else{
                sum+=right;
                idx+=right;
                if(idx>gaps.length-1) idx-=gaps.length;
            }
        }

        return sum;
    }

    private boolean all0() {
        for(int i:gaps){
            if(i!=0) return false;
        }
        return true;
    }

    private int getSum() {
        int sum=0;
        for(int i:gaps) sum+=i;
        return sum;
    }

    private int min(int i, int j) {
        if(i>=j) return j;
        return i;
    }
}