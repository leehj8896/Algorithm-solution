from collections import deque
import sys

def get_input():

    n, m = map(int, input('').split(' '))
    board = []
    for i in range(n):
        board.append(list(map(int, input(''))))
    
    return n, m, board


def print_line(list_line):
    for line in list_line:
        print(line)
    print('')


def get_new_position(board, pos, direction):

    i = -1
    j = -1
    d = -1

    if direction == 'up':
        i = pos[0]-1
        j = pos[1]
        d = pos[2]+1

    elif direction == 'down':
        i = pos[0]+1
        j = pos[1]
        d = pos[2]+1

    elif direction == 'left':
        i = pos[0]
        j = pos[1]-1
        d = pos[2]+1

    elif direction == 'right':
        i = pos[0]
        j = pos[1]+1
        d = pos[2]+1

    return (i, j, d)

def out(n, m, pos):

    if pos[0] >= 0 and pos[0] < n:
        if pos[1] >= 0 and pos[1] < m:
            return False
    return True

def get_distance(board):

    return -1


# def get_set_1(board):

#     visited = [[False for j in range(len(board))] for i in range(len(board[0]))]

#     # start = {'i':0, 'j':0, 'dist':1}
#     start = (0,0,1)
#     set_1 = set()
        
#     def dfs(pos):

#         if out(board, pos):
#             return
#         if visited[pos[0]][pos[1]]:
#             return
#         if board[pos[0]][pos[1]] == 1:
#             set_1.add(pos)
#             return

#         visited[pos[0]][pos[1]] = True

#         for direction in ['up', 'down', 'left', 'right']:

#             new_pos = get_new_position(pos, direction)
#             dfs(new_pos)

#     dfs(start)

#     return set_1

# sys.setrecursionlimit(999999)

n, m, board = get_input()

###########

start = (0,0,1)

visited = [[False for j in range(len(board))] for i in range(len(board))]
visited[start[0]][start[1]] = True

dq = deque()
dq.append(start)

set1 = set()

while True:

    curr = dq.popleft()

    for direction in ['up', 'down', 'left', 'right']:

        new_pos = get_new_position(board, curr, direction)
        if out(len(board), len(board[0]), new_pos):
            continue

        if board[new_pos[0]][new_pos[1]] == 1:
            set1.add(new_pos)

        if not visited[new_pos[0]][new_pos[1]]:
            if board[new_pos[0]][new_pos[1]] == 0:
                dq.append(new_pos)
                visited[new_pos[0]][new_pos[1]] = True

    if len(dq) == 0:
        break

# print_line(set1)

###########

start = (len(board)-1 ,len(board[0])-1 ,1)

visited = [[False for j in range(len(board))] for i in range(len(board))]
visited[start[0]][start[1]] = True

dq = deque()
dq.append(start)

set2 = set()

while True:

    curr = dq.popleft()

    for direction in ['up', 'down', 'left', 'right']:

        new_pos = get_new_position(board, curr, direction)
        if out(len(board), len(board[0]), new_pos):
            continue

        if board[new_pos[0]][new_pos[1]] == 1:
            set2.add(new_pos)

        if not visited[new_pos[0]][new_pos[1]]:
            if board[new_pos[0]][new_pos[1]] == 0:
                dq.append(new_pos)
                visited[new_pos[0]][new_pos[1]] = True

    if len(dq) == 0:
        break

# print_line(set2)

###########

min_dist = float('inf')

start = (0,0,1)

visited = [[False for j in range(len(board))] for i in range(len(board))]
visited[start[0]][start[1]] = True

dq = deque()
dq.append(start)

finished = False
while True:

    curr = dq.popleft()

    for direction in ['up', 'down', 'left', 'right']:

        new_pos = get_new_position(board, curr, direction)
        if out(len(board), len(board[0]), new_pos):
            continue

        if new_pos[0] == n-1 and new_pos[1] == m-1:
            min_dist = new_pos[2]
            finished = True
            break

        if not visited[new_pos[0]][new_pos[1]]:
            if board[new_pos[0]][new_pos[1]] == 0:
                dq.append(new_pos)
                visited[new_pos[0]][new_pos[1]] = True
    if finished:
        break
    if len(dq) == 0:
        break

###########

# min_dist = float('inf')
for line1 in set1:
    for line2 in set2:
        if line1[0] == line2[0] and line1[1] == line2[1]:
            if min_dist > line1[2] + line2[2]:
                min_dist = line1[2] + line2[2]

if min_dist == float('inf'):
    print(-1)
else:
    print(min_dist-1)

# set_1 = get_set_1(board)

# distance_int = get_distance(board)
# print(distance_int)

# if len(list_distance) > 0:
#     print(min(list_distance))
# else:
#     print(-1)