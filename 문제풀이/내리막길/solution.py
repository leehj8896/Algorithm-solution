def out(pos):
    if 0<=pos[0]<h:
        if 0<=pos[1]<w:
            return False
    return True


def dfs(pos):
    if pos[0]==h-1 and pos[1]==w-1:
        return 1
    if count_list[pos[0]][pos[1]]:
        return count_list[pos[0]][pos[1]]
    dx=[0,0,1,-1]
    dy=[1,-1,0,0]
    for i in range(4):
        new_i = pos[0]+dy[i]
        new_j = pos[1]+dx[i]
        if not out((new_i, new_j)):
            # if not visited[new_i][new_j]:
            if board[pos[0]][pos[1]] > board[new_i][new_j]:
                # dfs((new_i,new_j))
                # visited[new_i][new_j]=False
                count_list[pos[0]][pos[1]] += dfs((new_i,new_j))
                # visited[new_i][new_j]=True
    return count_list[pos[0]][pos[1]]


def init():
    h, w = map(int, input('').split(' '))
    board = []
    visited = []
    count_list = []
    for i in range(h):
        temp_list = list(map(int, input('').split(' ')))
        board.append(temp_list)
        visited.append([False]*w)
        count_list.append([0]*w)
    return h, w, board, count_list, visited


h, w, board, count_list, visited = init()
print(dfs((0,0)))