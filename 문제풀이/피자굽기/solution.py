import sys

def init():
    d, n = map(int, sys.stdin.readline().rstrip().split())
    oven_list = list(map(int, sys.stdin.readline().rstrip().split()))
    pizza_list = list(map(int, sys.stdin.readline().rstrip().split()))
    return d, n, oven_list, pizza_list


def get_end(start, end, goal, limit):

    if start > end:
        return -1

    middle = (start + end) // 2
    
    # middle에 들어갈 수 있을 때
    if oven_list[middle] >= goal:

        if middle+1 < limit:

            # middle+1에 들어갈 수 있을 때
            if oven_list[middle+1] >= goal:
                return get_end(middle+1, end, goal, limit)
            # middle+1에 들어갈 수 없을 때
            else:
                return middle

        else:
            return middle
    # middle에 들어갈 수 없을 때
    else:
        return get_end(start, middle-1, goal, limit)


d, n, oven_list, pizza_list = init()
# 가능한 지름으로 변환(정렬)
for i in range(0, d-1):
    if oven_list[i] < oven_list[i+1]:
        oven_list[i+1] = oven_list[i]
end = d
for i in range(n):
    # if end == 0:
    #     break
    end = get_end(0, end, pizza_list[i], end)
    if end == -1:
        break
    if end == 0 and i < n:
        # end = -1
        break
if end == -1 or end == 0:
    print(0)
else:
    print(end+1)
