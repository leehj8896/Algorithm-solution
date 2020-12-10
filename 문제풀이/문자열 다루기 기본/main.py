def solution(s):
    answer = True

    if len(s)==4:
        if s.isdigit():
            pass
        else:
            if s.isalpha():
                pass
            else:
                return False
    else:
        if len(s)==6:
            if s.isdigit():
                pass
            else:
                if s.isalpha():
                    pass
                else:
                    return False
        else:
            return False
    
    return answer