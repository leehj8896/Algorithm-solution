import sys


def init():
    ipt = sys.stdin.readline
    n = int(ipt())
    m = int(ipt())
    edge_list = []
    for _ in range(m):
        s, e, w = map(int, ipt().split())
        edge_list.append((s,e,w))
    return n, edge_list


def floyd_warshall():
    dist_list = [[float('inf') for _ in range(n+1)] for _ in range(n+1)]
    for s, e, w in edge_list:
        dist_list[s][e] = min(dist_list[s][e], w)
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                dist_list[i][j] = min(dist_list[i][j], dist_list[i][k]+dist_list[k][j])
    return dist_list


n, edge_list = init()
dist_list = floyd_warshall()
for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j or dist_list[i][j] == float('inf'):
            print(0, end=' ')
        else:
            print(dist_list[i][j], end=' ')
    print('')