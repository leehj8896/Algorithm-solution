def solution(x):
    answer = True

    _sum=get_sum(x)

    return x%_sum==0

def get_sum(num):

    _sum=0

    while True:
        _sum+=num%10
        num=num//10
        if num==0:
            break
    return _sum