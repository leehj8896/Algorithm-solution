import sys

def init():

    n = int(input(''))
    board = []
    for i in range(n):
        line = list(map(int, input('').split(' ')))
        board.append(line)

    return n, board


def get_new_position(pos, d):

    if d == 'up':
        return (pos[0]-1,pos[1])

    if d == 'down':
        return (pos[0]+1,pos[1])

    if d == 'right':
        return (pos[0],pos[1]+1)

    if d == 'left':
        return (pos[0],pos[1]-1)


def out(n, pos):

    if pos[0] >= 0 and pos[0] < n:
        if pos[1] >= 0 and pos[1] < n:
            return False
    return True
        

def dfs(n, board, visited, curr_pos, pos_set):

    visited[curr_pos[0]][curr_pos[1]] = True

    for d in ['up','down','right','left']:

        new_pos = get_new_position(curr_pos, d)

        if out(n, new_pos):
            continue
        if board[new_pos[0]][new_pos[1]] == 0:
            pos_set.add(curr_pos)
            continue
        if visited[new_pos[0]][new_pos[1]]:
            continue
        dfs(n, board, visited, new_pos, pos_set)


def get_part_list(n, board):

    visited = [[False for j in range(n)] for i in range(n)]
    
    part_list = []

    for i in range(n):
        for j in range(n):

            if board[i][j] == 0:
                continue
            if visited[i][j]:
                continue

            pos_set = set()
            dfs(n, board, visited, (i,j), pos_set)
            part_list.append(pos_set)

    return part_list


def print_line(line_list):

    for line in line_list:
        print(line)
    print('')


def get_distance(pos1, pos2):

    result = -1
    result += abs(pos1[0]-pos2[0])
    result += abs(pos1[1]-pos2[1])
    return result


def get_min_distance(part1_set, part2_set):

    min_distance = float('inf')

    for pos1 in part1_set:
        for pos2 in part2_set:

            distance = get_distance(pos1, pos2)
            if min_distance > distance:
                min_distance = distance
    return min_distance


sys.setrecursionlimit(99999)

n, board = init()
part_list = get_part_list(n, board)

result = float('inf')
for i in range(len(part_list)):
    for j in range(i+1, len(part_list)):

        min_distance = get_min_distance(part_list[i], part_list[j])
        if result > min_distance:
            result = min_distance

print(result)