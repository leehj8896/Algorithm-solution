function solution(arr, divisor) {
    var answer = [];

    var count=0;
    for(var i=0; i<arr.length; i++){
        if (arr[i]%divisor===0){
            count+=1;
        }
    }
    var answer=Array(count);
    if (count===0){
        return [-1];
    }

    var i=0;
    var j=0;
    while(true){
        if(i==count){
            break;
        }

        if (arr[j]%divisor===0){
            answer[i]=arr[j];
            i++;j++;
        }else{
            j++;
        }
        
    }

    answer.sort((a,b)=>a-b);
    return answer;
}