def solution(board):

    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j]==1:
                board[i][j]=get_min(board, i, j)+1

    result=0
    for i in range(len(board)):
        for j in range(len(board[0])):
            if result<board[i][j]:
                result=board[i][j]

    return pow(result, 2)

def get_min(board, curri, currj):
    
    list_temp=[0,0,0]
    if curri-1>=0 and currj-1>=0:
        list_temp[0]=board[curri-1][currj-1]
    if currj-1>=0:
        list_temp[1]=board[curri][currj-1]
    if curri-1>=0:
        list_temp[2]=board[curri-1][currj]
    
    return min(list_temp)

print(solution([[0,0,1,1],[1,1,1,1]]))