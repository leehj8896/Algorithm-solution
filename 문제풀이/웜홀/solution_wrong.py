# 음수 사이클?
import sys


def get_dist_list(v, edge_list):
    dist_list = [[float('inf') for _ in range(v+1)] for _ in range(v+1)]
    for s, e, w in edge_list:
        dist_list[s][e] = w
    for k in range(1, v+1):
        for i in range(1, v+1):
            for j in range(1, v+1):
                dist_list[i][j] = min(dist_list[i][j], dist_list[i][k]+dist_list[k][j])
                pass
    return dist_list


tc = int(sys.stdin.readline().rstrip())
for _ in range(tc):
    v, e1, e2 = map(int, sys.stdin.readline().rstrip().split(' '))
    edge_list = []
    for i in range(e1):
        s, e, t = map(int, sys.stdin.readline().rstrip().split(' '))
        edge_list.append((s,e,t))
        edge_list.append((e,s,t))
    for i in range(e2):
        s, e, t = map(int, sys.stdin.readline().rstrip().split(' '))
        edge_list.append((s,e,-t))
    dist_list = get_dist_list(v, edge_list)
    possible = False
    for i in range(1, v+1):
        if dist_list[i][i] < 0:
            possible = True
            break
    if possible:
        print('YES')
    else:
        print('NO')
pass