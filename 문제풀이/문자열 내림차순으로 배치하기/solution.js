function solution(s) {
    var answer = '';
    var chars=Array.from(s);
    var sorted=chars.sort((a,b)=>{
        if(a>b)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    });

    answer=sorted.join('');
    return answer;
}

