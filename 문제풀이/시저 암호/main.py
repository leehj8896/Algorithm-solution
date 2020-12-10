def solution(s, n):
    answer = ''
    
    for a in s:
        if a==' ':
            answer+=' '
        elif a.isupper():
            temp=ord(a)+n
            if temp>ord('Z'):
                temp=temp-ord('Z')+ord('A')-1
            answer+=chr(temp)
        elif a.islower():
            temp=ord(a)+n
            if temp>ord('z'):
                temp=temp-ord('z')+ord('a')-1
            answer+=chr(temp)

    return answer