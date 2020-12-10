function solution(s) {
    var answer = '';

    var arr_num=s.split(' ')

    var mapped=arr_num.map(x => parseInt(x))

    var min = Math.min.apply(null, mapped)
    var max = Math.max.apply(null, mapped)

    return min.toString()+' '+max.toString();
}

console.log(
    solution('-1 -2 -3 -4')
)