def init():

    n = int(input(''))
    crane_list = list(map(int, input('').split(' ')))
    m = int(input(''))
    box_list = list(map(int, input('').split(' ')))

    return n, m, crane_list, box_list


def get_box_idx(crane_idx, box_idx, box_excluded):

    while box_idx < m:

        if not box_excluded[box_idx]:
            if crane_list[crane_idx] >= box_list[box_idx]:
                return box_idx

        box_idx += 1

    return -1

def get_time():

    if max(crane_list) < max(box_list):
        return -1

    crane_list.sort(reverse=True)
    box_list.sort(reverse=True)

    crane_excluded = [False] * n
    box_excluded = [False] * m

    count = 0

    while True:

        crane_idx = 0
        box_idx = -1

        finished = False

        while crane_idx < n and box_idx < m:

            box_idx = get_box_idx(crane_idx, box_idx+1, box_excluded)
            if crane_idx == 0 and box_idx < 0:
                finished = True
                break

            box_excluded[box_idx] = True
            count += 1

            crane_idx += 1

        if finished:
            break
    
    return count


n, m, crane_list, box_list = init()

result = get_time()

print(result)