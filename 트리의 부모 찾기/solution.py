import sys
from collections import deque

n = int(input(''))

dict_graph = dict()
for i in range(n-1):

    a, b = map(int, sys.stdin.readline().rstrip().split(' '))

    if a not in dict_graph:
        dict_graph[a] = set()
    if b not in dict_graph:
        dict_graph[b] = set()
    
    dict_graph[a].add(b)
    dict_graph[b].add(a)

q = deque([1])
list_checked = [False for i in range(n+1)]
list_parent = [0 for i in range(n+1)]
list_checked[0] = True
list_checked[1] = True
list_parent[0] = 0
list_parent[1] = 1

while len(q) > 0:

    curr = q.popleft()

    for tmp in dict_graph[curr]:
        if not list_checked[tmp]:
            list_checked[tmp] = True
            q.append(tmp)
            list_parent[tmp] = curr

# print('\n'.join(map(str, list_parent[2:])))
for i in range(2, len(list_parent)):
    print(list_parent[i])