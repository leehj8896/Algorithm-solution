function solution(n) {


    var isprime=Array.from({length:n+1},()=>true);
    isprime[0]=false;
    isprime[1]=false;

    for(var i=2; i<=n; i++)
    {
        // 소수가 아니면 패스
        if(!isprime[i])
            continue;
        
        // 소수이면 배수들 false
        for(var j=i*2; j<=n; j+=i)
            isprime[j]=false;
    }

    var count=0;
    for(var i=2; i<=n; i++)
        if(isprime[i])    
            count++;
    
    return count;
}
