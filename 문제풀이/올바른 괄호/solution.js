function solution(s){
    var answer = true;

    var stack=Array()
    for(var i=0; i<s.length; i++)
    {
        if(s[i]==='(')
        {
            stack.push(s[i])
        }
        else if(s[i]===')')
        {
            if(stack.length-1<0)
            {
                return false
            }
            else
            {
                if(stack[stack.length-1]==='(')
                {
                    stack.pop()
                }
                else if(stack[stack.length-1]===')')
                {
                    return false
                }
            }
        }
    }    

    if(stack.length===0)
        return true
    return false
}