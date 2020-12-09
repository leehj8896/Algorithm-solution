function solution(x, n) {
    var answer = [];

    answer=Array(n);
    for(var i=0; i<n; i++)
    {
        answer[i]=(i+1)*x;
    }

    return answer;
}