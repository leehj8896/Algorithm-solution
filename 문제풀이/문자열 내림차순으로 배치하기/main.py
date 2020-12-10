def solution(s):

    list_c=sorted(s, reverse=True)
    result=''
    for c in list_c:
        result+=c

    return result

if __name__ == "__main__":
    
    s='Zbcdefg'

    print(solution(s))