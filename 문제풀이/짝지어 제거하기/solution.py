def solution(s):

    list_stack=[]

    for i in range(len(s)):
        if 0<len(list_stack):
            if list_stack[len(list_stack)-1] == s[i]:
                list_stack.pop()
            else:
                list_stack.append(s[i])
        else:
            list_stack.append(s[i])
    
    if len(list_stack)==0:
        return 1
    return 0