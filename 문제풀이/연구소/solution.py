from itertools import combinations
import copy

def get_input():

    n, m = map(int, input('').split(' '))

    board = []
    for i in range(n):
        board.append(list(map(int, input('').split(' '))))
    return n, m, board

def get_combi(board):

    list_pos = []
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 0:
                list_pos.append((i, j))

    return list(combinations(list_pos, 3))

def dfs(new_board, pos):

    if pos[0] >= 0 and pos[0] < len(new_board) and \
        pos[1] >= 0 and pos[1] < len(new_board[0]) and \
        new_board[pos[0]][pos[1]] == 0:

        new_board[pos[0]][pos[1]] = 2
        dfs(new_board, (pos[0]+1, pos[1]))
        dfs(new_board, (pos[0]-1, pos[1]))
        dfs(new_board, (pos[0], pos[1]+1))
        dfs(new_board, (pos[0], pos[1]-1))

    else:
        return

def get_new_board(board):

    new_board = copy.deepcopy(board)

    list_2pos = []
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == 2:
                list_2pos.append((i, j))

    for pos in list_2pos:
        new_board[pos[0]][pos[1]] = 0
        dfs(new_board, pos)

    return new_board

def get_zero_num(new_board):

    count = 0
    for i in range(len(new_board)):
        for j in range(len(new_board[0])):
            if new_board[i][j] == 0:
                count += 1

    return count


# init()
n, m, board = get_input()

# get_combi()
list_combi = get_combi(board)

list_max = []

# repeat_combi()
for combi in list_combi:

    board[combi[0][0]][combi[0][1]] = 1
    board[combi[1][0]][combi[1][1]] = 1
    board[combi[2][0]][combi[2][1]] = 1

    # fill_with_2()
    new_board = get_new_board(board)
    # append_zero_num()
    zero_num = get_zero_num(new_board)
    list_max.append(zero_num)

    board[combi[0][0]][combi[0][1]] = 0
    board[combi[1][0]][combi[1][1]] = 0
    board[combi[2][0]][combi[2][1]] = 0

# get_max()
print(max(list_max))