function solution(people, limit) {

    people.sort((a,b)=>a-b)

    var result=0
    while(true)
    {
        if(people.length===0)
            break
        if(people.length===1)
        {
            result++
            break
        }

        if(people[0]+people[people.length-1]<=limit)
        {
            people.pop()
            people.shift()
            result++
        }
        else
        {
            people.pop()
            result++
        }
    }
    return result
}
console.log(
    solution([70, 50,50, 80], 100)
)