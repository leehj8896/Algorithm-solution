from collections import deque

def get_new_pos(pos, d):
    if d == 'up':
        return (pos[0]-1,pos[1],pos[2]+1)
    elif d == 'down':
            return (pos[0]+1,pos[1],pos[2]+1)
    elif d == 'left':
            return (pos[0],pos[1]-1,pos[2]+1)
    elif d == 'right':
            return (pos[0],pos[1]+1,pos[2]+1)


def out(n, pos):
    if pos[0] >= 0 and pos[0] < n:
        if pos[1] >= 0 and pos[1] < n:
            return False
    return True


def get_route(prev_pos, start_pos, curr_pos, route_set):

    if curr_pos[0] == start_pos[0] and curr_pos[1] == start_pos[1]:
        route_set.add((start_pos[0], start_pos[1]))
        return

    get_route(prev_pos, start_pos, prev_pos[curr_pos[0]][curr_pos[1]], route_set)
    route_set.add(curr_pos)

def get_distance(n, board, start_pos):

    max_distance = float('-inf')
    end_pos = tuple()

    prev_pos = [[(0,0) for j in range(n)] for i in range(n)]

    visited = [[False for j in range(n)] for i in range(n)]
    visited[start_pos[0]][start_pos[1]] = True

    dq = deque()
    dq.append(start_pos)
    
    while len(dq) > 0:

        curr_pos = dq.popleft()
        if max_distance < curr_pos[2]:
            max_distance = curr_pos[2]
            end_pos = (curr_pos[0], curr_pos[1])

        for d in ['up','down','left','right']:

            new_pos = get_new_pos(curr_pos, d)

            if out(n, new_pos):
                continue
            if visited[new_pos[0]][new_pos[1]]:
                continue
            if board[curr_pos[0]][curr_pos[1]] >= board[new_pos[0]][new_pos[1]]:
                continue

            visited[new_pos[0]][new_pos[1]] = True
            prev_pos[new_pos[0]][new_pos[1]] = (curr_pos[0], curr_pos[1])
            dq.append(new_pos)

    route_set = set()
    get_route(prev_pos, start_pos, end_pos, route_set)

    return route_set


def init():

    board = []
    n = int(input(''))
    for i in range(n):
        line = list(map(int, input('').split(' ')))
        board.append(line)

    return n, board


n, board = init()

max_distance = float('-inf')

max_route_set = set()

for i in range(n):
    for j in range(n):

        if (i,j) in max_route_set:
            continue

        start = (i,j, 1)
        route_set = get_distance(n, board, start)
        distance = len(route_set)

        if max_distance < distance:
            max_distance = distance
            max_route_set = route_set

# print(max_route_set)
print(max_distance)    