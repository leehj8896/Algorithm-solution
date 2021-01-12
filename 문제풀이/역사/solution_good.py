import sys


def init():
    n, k = map(int, sys.stdin.readline().rstrip().split(' '))
    order_list = [tuple(map(int, sys.stdin.readline().rstrip().split(' '))) for _ in range(k)]
    s = int(sys.stdin.readline().rstrip())
    pair_list = [tuple(map(int, sys.stdin.readline().rstrip().split(' '))) for _ in range(s)]
    # dist_list = [[float('inf') for _ in range(n+1)] for _ in range(n+1)]
    dist_list = [[False for _ in range(n+1)] for _ in range(n+1)]
    return n, k, order_list, s, pair_list, dist_list


n, k, order_list, s, pair_list, dist_list = init()
for start, end in order_list:
    # dist_list[start][end] = 1
    dist_list[start][end] = True
for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            # dist_list[i][j] = min(dist_list[i][j], dist_list[i][k]+dist_list[k][j])
            dist_list[i][j] = dist_list[i][j] or (dist_list[i][k] and dist_list[k][j])
for start, end in pair_list:
    # if dist_list[start][end] == float('inf') and dist_list[end][start] == float('inf'):
    #     sys.stdout.write('0\n')
    # elif dist_list[start][end] == float('inf'):
    #     sys.stdout.write('1\n')
    # elif dist_list[end][start] == float('inf'):
    #     sys.stdout.write('-1\n')
    if not dist_list[start][end] and not dist_list[end][start]:
        sys.stdout.write('0\n')
    elif not dist_list[start][end]:
        sys.stdout.write('1\n')
    elif not dist_list[end][start]:
        sys.stdout.write('-1\n')
