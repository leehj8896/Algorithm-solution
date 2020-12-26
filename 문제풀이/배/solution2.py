from collections import deque

def init():

    n = int(input(''))
    crane_list = deque(map(int, input('').split(' ')))
    m = int(input(''))
    box_dq = list(map(int, input('').split(' ')))

    return n, m, crane_list, box_dq


def get_box_idx(box_dq, crane_list):

    i = 0

    while i + len(crane_list) < len(box_dq):

        if box_dq[i + len(crane_list)] > crane_list[0]:
            break
        i += len(crane_list)

    return i

def get_time(crane_list, box_dq):

    if max(crane_list) < max(box_dq):
        return -1

    crane_list = sorted(crane_list)
    box_dq = deque(sorted(box_dq))

    crane_dict = get_dict()

    

        



    return count


n, m, crane_list, box_dq = init()

result = get_time(crane_list, box_dq)

print(result)