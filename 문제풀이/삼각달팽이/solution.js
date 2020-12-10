function solution(n) {
    var answer = [];

    var myarr=Array.from(
        {length:n},
        ()=>Array.from(
            {length:n},
            ()=>0
        )
    )

    var i=0
    var j=0
    var num=1

    while(true)
    {
        while(true)
        {
            myarr[i][j]=num
            num++
            if(i+1===n || myarr[i+1][j]!=0)
            {
                break
            }
            else
            {
                i++
            }
        }
        j++
        if(myarr[i][j]!=0)
            break
        while(true)
        {
            myarr[i][j]=num
            num++
            if(j+1===n || myarr[i][j+1]!=0)
            {
                break
            }
            else
            {
                j++
            }
        }
        i--
        j--
        if(myarr[i][j]!=0)
            break
        while(true)
        {
            myarr[i][j]=num
            num++
            if(myarr[i-1][j-1]!=0)
            {
                break
            }
            else
            {
                j--
                i--
            }
        }
        i++
        if(myarr[i][j]!=0)
            break
    }

    for(var i=0; i<myarr.length; i++)
    {
        for(var j=0; j<myarr.length; j++)
        {
            if(myarr[i][j]!=0)
            {
                answer.push(myarr[i][j])
            }
        }
    }

    return answer;
}

console.log(
    solution(3)
)