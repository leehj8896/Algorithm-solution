from collections import deque

def get_up(board):

    new_board = [[0 for j in range(len(board))] for i in range(len(board))]

    for j in range(len(board)):

        dq_result = deque()
        dq_tmp = deque()
        for i in range(len(board)):
            if board[i][j] != 0:
                dq_tmp.append(board[i][j])
        
        while True:

            if len(dq_tmp) >= 2:
                num1 = dq_tmp.popleft()
                num2 = dq_tmp.popleft()

                if num1 == num2:
                    dq_result.append(num1+num2)
                else:
                    dq_result.append(num1)
                    dq_tmp.appendleft(num2)

            if len(dq_tmp) == 1:
                dq_result.append(dq_tmp.popleft())
                break

            if len(dq_tmp) == 0:
                break       
        
        i = 0
        while len(dq_result) > 0:
            new_board[i][j] = dq_result.popleft()
            i += 1

    return new_board

def get_left(board):

    new_board = [[0 for j in range(len(board))] for i in range(len(board))]

    for i in range(len(board)):

        dq_result = deque()
        dq_tmp = deque()
        for j in range(len(board)):
            if board[i][j] != 0:
                dq_tmp.append(board[i][j])
        
        while True:

            if len(dq_tmp) >= 2:
                num1 = dq_tmp.popleft()
                num2 = dq_tmp.popleft()

                if num1 == num2:
                    dq_result.append(num1+num2)
                else:
                    dq_result.append(num1)
                    dq_tmp.appendleft(num2)

            if len(dq_tmp) == 1:
                dq_result.append(dq_tmp.popleft())
                break

            if len(dq_tmp) == 0:
                break       
        
        j = 0
        while len(dq_result) > 0:
            new_board[i][j] = dq_result.popleft()
            j += 1

    return new_board

def get_down(board):

    new_board = [[0 for j in range(len(board))] for i in range(len(board))]

    for j in range(len(board)):

        dq_result = deque()
        dq_tmp = deque()
        for i in range(len(board)):
            if board[i][j] != 0:
                dq_tmp.append(board[i][j])
        
        while True:

            if len(dq_tmp) >= 2:
                num1 = dq_tmp.pop()
                num2 = dq_tmp.pop()

                if num1 == num2:
                    dq_result.appendleft(num1+num2)
                else:
                    dq_result.appendleft(num1)
                    dq_tmp.append(num2)

            if len(dq_tmp) == 1:
                dq_result.appendleft(dq_tmp.pop())
                break

            if len(dq_tmp) == 0:
                break       
        
        i = len(new_board[0])-1
        while len(dq_result)>0:
            new_board[i][j] = dq_result.pop()
            i -= 1

    return new_board

def get_right(board):

    new_board = [[0 for j in range(len(board))] for i in range(len(board))]

    for i in range(len(board)):

        dq_result = deque()
        dq_tmp = deque()
        for j in range(len(board)):
            if board[i][j] != 0:
                dq_tmp.append(board[i][j])
        
        while True:

            if len(dq_tmp) >= 2:
                num1 = dq_tmp.pop()
                num2 = dq_tmp.pop()

                if num1 == num2:
                    dq_result.appendleft(num1+num2)
                else:
                    dq_result.appendleft(num1)
                    dq_tmp.append(num2)

            if len(dq_tmp) == 1:
                dq_result.appendleft(dq_tmp.pop())
                break

            if len(dq_tmp) == 0:
                break       
        
        j = len(new_board[0])-1
        while len(dq_result)>0:
            new_board[i][j] = dq_result.pop()
            j -= 1

    return new_board

def get_max(board):
    
    list_max = []
    for i in range(len(board)):
        list_max.append(max(board[i]))
    return max(list_max)

def myfunc(idx, board, list_max):

    if idx == 5:

        list_max.append(get_max(board))
        return

    up = get_up(board)
    myfunc(idx+1, up, list_max)
    down = get_down(board)
    myfunc(idx+1, down, list_max)
    left = get_left(board)
    myfunc(idx+1, left, list_max)
    right = get_right(board)
    myfunc(idx+1, right, list_max)


if __name__ == "__main__":

    n = int(input())

    board = []
    for i in range(n):
        board.append(list(map(int, input().split(' '))))

    list_max = []
    myfunc(0, board, list_max)

    print(max(list_max))