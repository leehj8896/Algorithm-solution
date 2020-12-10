def solution(n):
    answer = 0

    str_n=str(n)
    list_n=list(str_n)
    list_n=sorted(list_n, reverse=True)
    temp=''.join(list_n)
    answer=int(temp)

    return answer

if __name__ == "__main__":
    
    n=118372
    print(
        solution(n)
    )
    
    pass