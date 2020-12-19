
def get_new_pos(pos, d):
    if d == 'u':
        return (pos[0]+1, pos[1])
    if d == 'd':
        return (pos[0]-1, pos[1])
    if d == 'l':
        return (pos[0], pos[1]-1)
    if d == 'r':
        return (pos[0], pos[1]+1)


def out(pos):
    if 0 <= pos[0] < len(board):
        if 0 <= pos[1] < len(board[0]):
            return False
    return True


def get_ord(pos):
    word = board[pos[0]][pos[1]]
    return ord(word) - ord('A')


def dfs(curr_pos, count):

    di = [1,-1,0,0]
    dj = [0,0,1,-1]

    global max_length

    if count == 26:
        max_length = 26
        return

    max_length = max(max_length, count)

    # for d in ['u','d','l','r']:
    for d in range(4):

        # new_pos = get_new_pos(curr_pos, d)
        new_pos = (curr_pos[0]+di[d], curr_pos[1]+dj[d])

        if out(new_pos):
            continue
        if visited[get_ord(new_pos)]:
        # if board[new_pos[0]][new_pos[1]] in visited:
            continue

        # visited.add(board[new_pos[0]][new_pos[1]])
        visited[get_ord(new_pos)] = True
        dfs(new_pos, count+1)
        visited[get_ord(new_pos)] = False
        # visited.remove(board[new_pos[0]][new_pos[1]])



def init():
    n, m = map(int, input('').split(' '))
    board = [list(input('')) for i in range(n)]
    return n, m, board


n, m, board = init()

visited = [False] * 26
visited[get_ord((0,0))] = True
# visited = set()
# visited.add(board[0][0])

max_length = float('-inf')

start = (0,0)

dfs(start, 1)

print(max_length)