function solution(n) {
    var answer = 0;

    answer=get_fibo(n)%1234567n

    return Number(answer);
}

function get_fibo(n)
{
    var fibo=Array(n+1)
    fibo[0]=0n
    fibo[1]=1n

    for(var i=2; i<=n; i++)
    {
        fibo[i]=fibo[i-1]+fibo[i-2]
    }

    return fibo[n]
}

console.log(
    solution(5)
)