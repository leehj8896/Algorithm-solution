# 투 포인터

from collections import deque

def init():

    n = int(input(''))
    num_list = list(map(int, input('').split(' ')))

    return n, num_list

n, num_list = init()

num_list.sort()

min_value = float('inf')
min_combi = [float('inf'), float('inf'), float('inf')]

finished = False
for i in range(n-2):
    
    start_value = num_list[i]
    q = deque(num_list[i+1:])

    left = q.popleft()
    right = q.pop()

    while True:

        temp_combi = [start_value, left, right]
        temp_value = abs(sum(temp_combi))

        if temp_value < min_value:
            min_combi = temp_combi
            min_value = temp_value

        if len(q) == 0:
            break

        if start_value + left + right == 0:
            finished = True
            break

        elif start_value + left + right > 0:
            right = q.pop()

        elif start_value + left + right < 0:
            left = q.popleft()

    if finished:
        break

min_combi.sort()
for i in range(3):
    print(min_combi[i], end=' ')