def solution(list_num):

    set_num = set(list_num)

    if len(set_num) >= len(list_num) // 2:
        return len(list_num) // 2
        
    elif len(set_num) < len(list_num) // 2:
        return len(set_num)
    
    return -1