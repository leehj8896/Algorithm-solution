import sys, bisect


def init():
    n, k = map(int, sys.stdin.readline().rstrip().split(' '))
    order_list = []
    directed_list = [[] for _ in range(n+1)]
    undirected_list = [[] for _ in range(n+1)]
    for i in range(k):
        start, end = map(int, sys.stdin.readline().rstrip().split(' '))
        order_list.append((start, end))
        directed_list[start].append(end)
        undirected_list[start].append(end)
        undirected_list[end].append(start)
    s = int(sys.stdin.readline().rstrip())
    pair_list = []
    for i in range(s):
        start, end = map(int, sys.stdin.readline().rstrip().split(' '))
        pair_list.append((start, end))
    part_list = [0 for _ in range(n+1)]
    index_list = [-1 for _ in range(n+1)]
    sorted_list = []
    return n, k, order_list, s, pair_list, part_list, undirected_list, directed_list, sorted_list, index_list


def dfs_ts(visited, curr_num):
    visited[curr_num] = True
    for next_num in directed_list[curr_num]:
        if not visited[next_num]:
            dfs_ts(visited, next_num)
    sorted_list.append(curr_num)
    index_list[curr_num] = len(sorted_list) - 1
    

def set_sorted_list():
    visited = [False for i in range(n+1)]
    for i in range(1, n+1):
        if not visited[i]:
            dfs_ts(visited, i)


def dfs(curr_num, part):
    part_list[curr_num] = part
    for next_num in undirected_list[curr_num]:
        if part_list[next_num] == 0:
            dfs(next_num, part)


def set_part_list():
    part = 1
    for i in range(1, n+1):
        if part_list[i] == 0:
            dfs(i, part)
            part += 1


def check(pair):
    start, end = pair
    if part_list[start] == part_list[end]:
        if index_list[start] < index_list[end]:
            return 1
        else:
            return -1
    else:
        return 0


n, k, order_list, s, pair_list, part_list, undirected_list, directed_list, sorted_list, index_list = init()
set_sorted_list()
set_part_list()
for pair in pair_list:
    sys.stdout.write(f'{check(pair)}\n')