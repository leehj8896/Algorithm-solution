import sys


def binary_search(length_list, curr_height, start, end):
    if start > end:
        return start
    mid = (start+end)//2
    if length_list[mid] < curr_height:
        return binary_search(length_list, curr_height, mid+1, end)
    else:
        return binary_search(length_list, curr_height, start, mid-1)


def init():
    rock_num, height = map(int, sys.stdin.readline().rstrip().split(' '))
    top_list, bottom_list = [], []
    for i in range(rock_num):
        if i % 2 == 0:
            bottom_list.append(int(sys.stdin.readline().rstrip()))
        elif i % 2 == 1:
            top_list.append(height-int(sys.stdin.readline().rstrip()))
    return rock_num, height, top_list, bottom_list, float('inf'), 0


rock_num, height, top_list, bottom_list, min_num, min_count = init()
bottom_list.sort()
top_list.sort()
for h in range(height):
    bottom_meet = rock_num//2 - binary_search(bottom_list, h+0.5, 0, rock_num//2-1)
    top_meet = binary_search(top_list, h+0.5, 0, rock_num//2-1)
    if min_num == bottom_meet+top_meet:
        min_count += 1
    elif min_num > bottom_meet+top_meet:
        min_num = bottom_meet+top_meet
        min_count = 1
print(min_num, min_count)
