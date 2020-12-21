# top-down

import sys
sys.setrecursionlimit(99999)

def out(i, j):
    if 0 <= i < n and 0 <= j < n:
        return False
    return True


def get_distance(curr_i, curr_j):

    if dist[curr_i][curr_j] == 1:
        
        dy = [1,-1,0,0]
        dx = [0,0,1,-1]
        for i in range(4):

            new_i = curr_i + dy[i]
            new_j = curr_j + dx[i]
            if out(new_i, new_j):
                continue
            if board[curr_i][curr_j] >= board[new_i][new_j]:
                continue
            dist[curr_i][curr_j] = max(dist[curr_i][curr_j], get_distance(new_i, new_j) + 1)

        return dist[curr_i][curr_j]

    else:
        return dist[curr_i][curr_j]


def init():

    board = []
    n = int(input(''))
    for i in range(n):
        line = list(map(int, input('').split(' ')))
        board.append(line)

    return n, board


def print_line(line_list):
    for line in line_list:
        print(line)


n, board = init()

dist = [[1] * n for i in range(n)]

max_distance = 0

for i in range(n):
    for j in range(n):
        
        distance = get_distance(i, j)
        max_distance = max(max_distance, distance)
        
print(max_distance)