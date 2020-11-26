def solution(s):

    list_num = list(map(int, s.split(' ')))

    return ' '.join([str(min(list_num)), str(max(list_num))])