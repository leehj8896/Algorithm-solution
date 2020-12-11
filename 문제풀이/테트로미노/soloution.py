def bar(board, set_sum, i, j):

    if j+3 < len(board[0]):
        set_sum.add(sum(board[i][j:j+4]))

    if i+3 < len(board):
        result = board[i][j]
        result += board[i+1][j]
        result += board[i+2][j]
        result += board[i+3][j]
        set_sum.add(result)

def square(board, set_sum, i, j):

    if i+1 < len(board) and j+1 < len(board[0]):
        result = board[i][j]
        result += board[i+1][j]
        result += board[i][j+1]
        result += board[i+1][j+1]
        set_sum.add(result)

def L(board, set_sum, i, j):

    if i+2 < len(board) and j+1 < len(board[0]):

        result = 0
        result += board[i][j]
        result += board[i+1][j]
        result += board[i+2][j]
        result += board[i+2][j+1]
        set_sum.add(result)

        result = 0
        result += board[i+2][j]
        result += board[i][j+1]
        result += board[i+1][j+1]
        result += board[i+2][j+1]
        set_sum.add(result)

        result = 0
        result += board[i][j]
        result += board[i][j+1]
        result += board[i+1][j]
        result += board[i+2][j]
        set_sum.add(result)

        result = 0
        result += board[i][j]
        result += board[i][j+1]
        result += board[i+1][j+1]
        result += board[i+2][j+1]
        set_sum.add(result)

    if i+1 < len(board) and j+2 < len(board[0]):

        result = 0
        result += board[i][j]
        result += board[i][j+1]
        result += board[i][j+2]
        result += board[i+1][j+2]
        set_sum.add(result)

        result = 0
        result += board[i][j]
        result += board[i+1][j]
        result += board[i][j+1]
        result += board[i][j+2]
        set_sum.add(result)

        result = 0
        result += board[i][j+2]
        result += board[i+1][j]
        result += board[i+1][j+1]
        result += board[i+1][j+2]
        set_sum.add(result)

        result = 0
        result += board[i][j]
        result += board[i+1][j]
        result += board[i+1][j+1]
        result += board[i+1][j+2]
        set_sum.add(result)

def zigzag(board, set_sum, i, j):

    if i+2 < len(board) and j+1 < len(board[0]):

        result = 0
        result += board[i][j]
        result += board[i+1][j]
        result += board[i+1][j+1]
        result += board[i+2][j+1]
        set_sum.add(result)

        result = 0
        result += board[i][j+1]
        result += board[i+1][j+1]
        result += board[i+1][j]
        result += board[i+2][j]
        set_sum.add(result)

    if i+1 < len(board) and j+2 < len(board[0]):

        result = 0
        result += board[i][j+1]
        result += board[i][j+2]
        result += board[i+1][j]
        result += board[i+1][j+1]
        set_sum.add(result)

        result = 0
        result += board[i][j]
        result += board[i][j+1]
        result += board[i+1][j+1]
        result += board[i+1][j+2]
        set_sum.add(result)

def O(board, set_sum, i, j):
    
    if i+1 < len(board) and j+2 < len(board[0]):

        result = 0
        result += board[i][j]
        result += board[i][j+1]
        result += board[i][j+2]
        result += board[i+1][j+1]
        set_sum.add(result)

        result = 0
        result += board[i][j+1]
        result += board[i+1][j]
        result += board[i+1][j+1]
        result += board[i+1][j+2]
        set_sum.add(result)

    if i+2 < len(board) and j+1 < len(board[0]):

        result = 0
        result += board[i+1][j]
        result += board[i][j+1]
        result += board[i+1][j+1]
        result += board[i+2][j+1]
        set_sum.add(result)

        result = 0
        result += board[i+1][j+1]
        result += board[i][j]
        result += board[i+1][j]
        result += board[i+2][j]
        set_sum.add(result)


n, m = map(int, input('').split(' '))

board = []
for i in range(n):
    line = list(map(int, input('').split(' ')))
    board.append(line)

set_sum = set()
for i in range(n):
    for j in range(m):

        bar(board, set_sum, i, j)
        square(board, set_sum, i, j)
        L(board, set_sum, i, j)
        zigzag(board, set_sum, i, j)
        O(board, set_sum, i, j)

print(max(set_sum))