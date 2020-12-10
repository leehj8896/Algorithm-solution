function solution(s, n) {
    var answer = '';

    for(var i=0; i<s.length; i++)
    {
        if(s[i]===' ')
        {
            answer+=' ';
        }
        else if('a'<=s[i] && s[i]<='z')
        {
            var from=s[i].charCodeAt();
            var to=from+n;
            if('z'<String.fromCharCode(to))
            {
                var result=to-('z'.charCodeAt()-'a'.charCodeAt()+1);
                answer+=String.fromCharCode(result);
            }
            else
            {
                answer+=String.fromCharCode(to);
            }
        }
        else if('A'<=s[i] && s[i]<='Z')
        {
            var from=s[i].charCodeAt();
            var to=from+n;
            if('Z'<String.fromCharCode(to))
            {
                var result=to-('Z'.charCodeAt()-'A'.charCodeAt()+1);
                answer+=String.fromCharCode(result);
            }
            else
            {
                answer+=String.fromCharCode(to);
            }
        }
    }

    return answer;
}

var s='a B z';
var n=4;
console.log(
    solution(s,n)
);