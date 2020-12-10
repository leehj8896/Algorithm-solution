function solution(arr)
{
    var answer = [];

    for(var i=0; i<arr.length; i++){
        if(answer.length>0){
            if(answer[answer.length-1]===arr[i]){
                continue
            }else{
                answer.push(arr[i]);
            }
        }else{
            answer.push(arr[i]);
        }
    }

    return answer;
}

var arr=[1,1,3,3,0,1,1]
console.log(
    solution(arr)
);