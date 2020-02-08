class Solution {
    int num;
    public String solution(int num) {
        this.num=num;

        String sum="";
        while(true){
            if(num==0) break;

            int rmd = (num-1)%3;
            if(rmd==0){
                sum=1+sum;
            }
            else if(rmd==1){
                sum=2+sum;
            }
            else if(rmd==2){
                sum=4+sum;
            }
            num=(num-1)/3;
        }

        return sum;
    }
}