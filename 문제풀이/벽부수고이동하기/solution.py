from collections import deque

def init():

    n, m = map(int, input('').split(' '))

    board = []
    for i in range(n):
        line = list(map(int, list(input(''))))
        board.append(line)

    return n, m, board


def out(i, j):

    if 0 <= i < n and 0 <= j < m:
        return False
    return True


def print_line(line_list):
    for line in line_list:
        print(line)


n, m, board = init()

dist = [[[-1, -1] for j in range(m)] for i in range(n)]
dist[0][0] = [1 , 1]

start = (0,0,0)

q = deque()
q.append(start)

di = [1,-1,0,0]
dj = [0,0,1,-1]

while len(q) > 0:

    curr_i, curr_j, curr_b = q.popleft()

    for i in range(4):

        new_i = curr_i + di[i]
        new_j = curr_j + dj[i]

        if out(new_i, new_j):
            continue
        
        # 다음 칸이 빈칸
        if board[new_i][new_j] == 0:
            # 방문한 적 X
            if dist[new_i][new_j][curr_b] == -1:
                # 추가
                dist[new_i][new_j][curr_b] = dist[curr_i][curr_j][curr_b] + 1
                q.append((new_i, new_j, curr_b))

        # 다음 칸이 벽
        if board[new_i][new_j] == 1:
            # 부순적 X
            if curr_b == 0:
                # 부수고 방문한 적 X
                if dist[new_i][new_j][1] == -1:
                    # 추가
                    dist[new_i][new_j][1] = dist[curr_i][curr_j][0] + 1
                    q.append((new_i, new_j, 1))

# 도착 불가
if max(dist[n-1][m-1]) == -1:
    print(-1)
# 하나라도 도착하면 큰 것
elif min(dist[n-1][m-1]) == -1:
    print(max(dist[n-1][m-1]))
# 둘 다 도착하면 작은 것
else:
    print(min(dist[n-1][m-1]))