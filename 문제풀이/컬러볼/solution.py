import sys

def print_line(line_list):
    for line in line_list:
        print(line)

n = int(input(''))

ball_list = []
for i in range(n):

    c, s = map(int, sys.stdin.readline().rstrip().split(' '))
    ball_list.append([s,c,i,0])

ball_list.sort(key=lambda x:x[0])

count_list = [0] * n

small_sum = 0
for i in range(1, n):
    
    ball_list[i][3] = small_sum - count_list[ball_list[i][1]]