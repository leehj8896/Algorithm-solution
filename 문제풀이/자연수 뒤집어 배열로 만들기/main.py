def solution(n):

    str_n=str(n)
    answer=reversed(list(str_n))
    
    return list(map(int, answer))