function solution(number, k) {
    
    var result=''

    var index=-1

    while(true)
    {
        var start=index+1
        var end=start+k

        var max=-1
        for(var i=start; i<=end; i++)
        {
            var tmp=parseInt(number[i])
            if(max<tmp)
            {
                max=tmp
            }
        }
        
        for(var i=end; i>=start; i--)
        {
            var tmp=parseInt(number[i])
            if(max===tmp)
            {
                index=i
                break
            }
        }

        result+=max.toString()
        k=k-(index-start)
        if(k===0)
            break
    }

    if(index+1<number.length)
        result+=number.substring(index+1, number.length)

    return result
}

console.log(
    solution('4177252841', 4)
)