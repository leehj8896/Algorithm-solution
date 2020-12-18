import sys 

def get_new_position(pos, d):

    if d=='u':
        return (pos[0]-1, pos[1])
    if d=='d':
        return (pos[0]+1, pos[1])
    if d=='r':
        return (pos[0], pos[1]+1)
    if d=='l':
        return (pos[0], pos[1]-1)


def out(r, c, pos):

    if pos[0] >= 0 and pos[0] < r:
        if pos[1] >= 0 and pos[1] < c:
            return False
    return True


def set_route(prev_list, pos, route_set):

    if pos[0] == 0 and pos[1] == 0:
        route_set.add(pos)
        return

    set_route(prev_list, prev_list[pos[0]][pos[1]], route_set)
    route_set.add(pos)

def rcs(board, result_list, prev_list, curr, route_set, visited):

    for d in ['u','d','r','l']:

        new_pos = get_new_position(curr, d)
        if out(len(board), len(board[0]), new_pos):
            continue

        route_set = set()
        set_route(prev_list, new_pos, route_set)
        if board[new_pos[0]][new_pos[1]] in route_set:
            continue

        
        if visited[new_pos[0]][new_pos[1]]:
            continue

        prev_list[new_pos[0]][new_pos[1]] = curr
        visited[new_pos[0]][new_pos[1]] = True
        rcs(board, result_list, prev_list, curr, route_set, visited)
        visited[new_pos[0]][new_pos[1]] = False
        result_list.append(route_set)


def init():

    board = []
    r, c = map(int, input('').split(' '))
    for i in range(r):
        line = list(input(''))
        board.append(line)

    prev_list = [[(0,0) for j in range(c)] for i in range(r)]
    visited = [[False for j in range(c)] for i in range(r)]

    return r,c,board,prev_list, visited

sys.setrecursionlimit(9999)

r, c, board, prev_list, visited = init()

curr = (0,0)
visited[0][0] = True
result_list = []
rcs(board, result_list, prev_list, curr, set(), visited)

print(max(result_list, key=lambda x:len(x)))