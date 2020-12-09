function solution(a, b) {

    var days=[
        31, 29, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31,
    ];

    var sum=0;
    for(var i=0; i<a-1; i++){
        sum+=days[i];
    }

    sum+=b;

    var yoes=['THU','FRI','SAT','SUN','MON','TUE','WED'];

    return yoes[sum%7];
}

var a=5;
var b=24;
console.log(
    solution(a,b)
);