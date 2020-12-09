function solution(arr1, arr2) {
    var answer = [[]];

    answer=Array.from(
        {length:arr1.length}, 
        ()=>Array.from({length:arr1[0].length}, ()=>0)
    );

    for(var i=0; i<arr1.length; i++)
    {
        for(var j=0; j<arr1[0].length; j++)
        {
            answer[i][j]=arr1[i][j]+arr2[i][j];
        }
    }

    return answer;
}