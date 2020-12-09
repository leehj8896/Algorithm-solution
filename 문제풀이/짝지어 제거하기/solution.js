function solution(s)
{
    var text=s

    while(true)
    {
        var before=text.length
        text=get_new_string(text)
        var after=text.length
        if(before===after)
            break
    }
    if(text==='')
        return 1
    else
        return 0
}
function get_new_string(text)
{

    var tobedeleted=Array.from({length:text.length}, ()=>false)
    var i=0;
    while(true)
    {
        if(text.length<=i)
        {
            break
        }
        if(text[i]===text[i+1])
        {
            tobedeleted[i]=true
            tobedeleted[i+1]=true
            i+=2
        }
        else
        {
            i+=1
        }
    }
    // console.log(tobedeleted)

    var result=get_updated(tobedeleted, text)


    for(var i=0; i<tobedeleted.length; i++)
    {
        if(tobedeleted[i])
            continue
        else
            result+=text[i]
    }
    
    return result
}

function get_updated(tobedeleted, text)
{
    var length=0
    for(var i=0; i<tobedeleted.length; i++)
    {
        if(!tobedeleted[i])
            length+=1
    }
    if(length===0)
        return ''
    var result=Array(length)
    var j=0;
    for(var i=0; i<length; i++)
    {
        if(tobedeleted[j])
        {
            j++
        }
        else
        {
            result[i]=text[j]
            j++
        }
    }
    return result.join('')
}

console.log(solution(
    'baabaa'
))