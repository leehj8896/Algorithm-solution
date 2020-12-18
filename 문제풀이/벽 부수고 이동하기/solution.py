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
    break_count = -1

    if direction == 'up':
        i = pos[0]-1
        j = pos[1]
        d = pos[2]+1
        break_count = pos[3]

    elif direction == 'down':
        i = pos[0]+1
        j = pos[1]
        d = pos[2]+1
        break_count = pos[3]

    elif direction == 'left':
        i = pos[0]
        j = pos[1]-1
        d = pos[2]+1
        break_count = pos[3]

    elif direction == 'right':
        i = pos[0]
        j = pos[1]+1
        d = pos[2]+1
        break_count = pos[3]

    if not out(board, (i,j)):
        if board[i][j] == 0:
            return (i, j, d, break_count)
        else:
            return (i, j, d, break_count+1)
    else:
        return None

def out(board, pos):

    # if pos['i'] >= 0 and pos['i'] < len(board):
    #     if pos['j'] >= 0 and pos['j'] < len(board[0]):
    #         return False
    if pos[0] >= 0 and pos[0] < len(board):
        if pos[1] >= 0 and pos[1] < len(board[0]):
            return False
    return True

def get_distance(board):

    start = (0,0,1,0)

    visited = [[False for j in range(len(board))] for i in range(len(board))]
    visited[start[0]][start[1]] = True

    dq = deque()
    dq.append(start)

    while True:

        curr = dq.popleft()
        print(curr)

        for direction in ['up', 'down', 'left', 'right']:

            new_pos = get_new_position(board, curr, direction)
            if new_pos is None:
                continue
            # print(new_pos)

            # if goal
            if new_pos[0] == len(board)-1 and new_pos[1] == len(board[0])-1:
                return new_pos[2]

            if not out(board, new_pos):
                # print('not out(board, new_pos)',not out(board, new_pos))
                if not visited[new_pos[0]][new_pos[1]]:
                    # print('not visited[new_pos[0]][new_pos[1]]',not visited[new_pos[0]][new_pos[1]])
                    if board[new_pos[0]][new_pos[1]] == 0 or curr[3] == 0:
                        # print('board[new_pos[0]][new_pos[1]] == 0 or new_pos[3] == 0',board[new_pos[0]][new_pos[1]] == 0 or new_pos[3] == 0)
                        dq.append(new_pos)
                        visited[new_pos[0]][new_pos[1]] = True

        if len(dq) == 0:
            break
    
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

# set_1 = get_set_1(board)

distance_int = get_distance(board)
print(distance_int)

# if len(list_distance) > 0:
#     print(min(list_distance))
# else:
#     print(-1)