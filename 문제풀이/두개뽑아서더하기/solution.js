function solution(numbers) {
    var answer = [];

    var myset = new Set();

    for(var i=0; i<numbers.length; i++){
        for(var j=i+1; j<numbers.length; j++){
            myset.add(numbers[i]+numbers[j]);
        }
    }

    answer=Array.from(myset);
    answer.sort((a,b)=>a-b);
    return answer;
}