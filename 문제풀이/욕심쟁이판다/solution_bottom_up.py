# bottom-up

def init():

    board = []
    n = int(input(''))
    for i in range(n):
        line = list(map(int, input('').split(' ')))
        board.append(line)

    return n, board


def out(i, j):
    if 0 <= i < n and 0 <= j < n:
        return False
    return True


def print_line(line_list):
    for line in line_list:
        print(line)


n, board = init()

pos_list = []
for i in range(n):
    for j in range(n):
        pos_list.append((i,j,board[i][j]))
pos_list.sort(reverse=True, key=lambda x:x[2])

dist = [[1] * n for i in range(n)]

dx = [0,0,1,-1]
dy = [-1,1,0,0]

for i in range(n*n):

    curr_i, curr_j, curr_v = pos_list[i]

    max_dist = 0
    for d in range(4):

        new_i = curr_i + dy[d]
        new_j = curr_j + dx[d]

        if out(new_i, new_j):
            continue

        new_v = board[new_i][new_j]
        if curr_v < new_v:
            max_dist = max(max_dist, dist[new_i][new_j])

    if max_dist > 0:
        dist[curr_i][curr_j] = max_dist + 1

print(max([max(dist[i]) for i in range(n)]))