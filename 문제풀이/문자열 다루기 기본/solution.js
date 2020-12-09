function solution(s) {
    var answer = true;

    if(s.length===4 || s.length===6)
    {
        for(var i=0; i<s.length; i++)
        {
            if(parseInt(s[i]))
            
            
            if('0'<=s[i] && s[i]<='9')
            {
                continue
            }
            else
            {
                return false;
            }
        }
    }
    else
    {
        return false;
    }

    return answer;
}

solution('test');