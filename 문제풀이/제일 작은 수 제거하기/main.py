def solution(arr):

    _min=min(arr)
    count=arr.count(_min)
    for i in range(count):
        arr.remove(_min)

    if len(arr)==0:
        return [-1]

    return arr