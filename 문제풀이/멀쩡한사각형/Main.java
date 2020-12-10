class Solution {
	public long solution(int w,int h) {

        long g = gcd(w,h);
        long mm=h/g;
        long nn=w/g;

        int count=0;
        for(int i=0; i<mm; i++){
            for(int j=0; j<nn; j++){

                double y1 = (double) mm/nn*j;
                double y2 = (double) mm/nn*(j+1);
                if((i<=y1&&y1<i+1)||(i<y2&&y2<=i+1)) count++;
            }
        }

		return (long)w*h-count*g;
	}

    private long gcd(long m, long n) {
        if(n==0){
            return m;
        }else{
            return gcd(n, m%n);
        }
    }
}