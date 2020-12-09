class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while(true){
            // System.out.println(a+" "+b);
            if(isAnswer(a,b)) break;

            a=(a-1)/2+1;
            b=(b-1)/2+1;
            answer++;
    
        }   
        return answer;
    }

    private boolean isAnswer(int a, int b) {
        if((a-1)/2==(b-1)/2)
            return true;
        return false;
    }
}