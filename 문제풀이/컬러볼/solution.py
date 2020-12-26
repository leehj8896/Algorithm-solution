import sys

n = int(input(''))

ball_list = []
size_list = [dict() for i in range(2001)]
for i in range(n):

    c, s = map(int, sys.stdin.readline().rstrip().split(' '))
    ball_list.append([c, s])

    size_list[s][c]