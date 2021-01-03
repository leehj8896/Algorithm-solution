# 시간 초과
import sys
sys.setrecursionlimit(99999)

def dfs(start, min_cost):
    visited[start] = True
    if start == end:
        min_list.append(min_cost)
    for key in b_dict[start]:
        if not visited[key]:
            dfs(key, min(min_cost, b_dict[start][key]))
    visited[start] = False


def init():
    i_num, b_num = map(int, sys.stdin.readline().rstrip().split(' '))
    b_list = []
    for i in range(b_num):
        a,b,c = map(int, sys.stdin.readline().rstrip().split(' '))
        b_list.append((a,b,c))
    start, end = map(int, sys.stdin.readline().rstrip().split(' '))
    return i_num, b_num, b_list, start, end


def to_dict():
    b_dict = dict()
    for bridge in b_list:
        a,b,c = bridge
        if a not in b_dict:
            b_dict[a] = dict()
        if b not in b_dict[a]:
            b_dict[a][b] = c
        else:
            b_dict[a][b] = max(b_dict[a][b], c)
        if b not in b_dict:
            b_dict[b] = dict()
        if a not in b_dict[b]:
            b_dict[b][a] = c
        else:
            b_dict[b][a] = max(b_dict[b][a], c)
    return b_dict


i_num, b_num, b_list, start, end = init()
b_dict = to_dict()
visited = [False] * (i_num + 1)
min_list = []
dfs(start, float('inf'))
print(max(min_list))