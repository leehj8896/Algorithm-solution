function solution(a, b) {
    var answer = 0;

    var big=Math.max(a,b);
    var small=Math.min(a,b);

    return ((big+small)/2)*(big-small+1);
}

console.log(
    solution(5, 3)
);