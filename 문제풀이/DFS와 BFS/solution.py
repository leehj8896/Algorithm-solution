from collections import deque

# def dfs(list_edge, list_checked, curr):

#     print(curr, end=' ')
#     list_checked[curr] = True
#     for node in list_edge[curr]:
#         if not list_checked[node]:
#             dfs(list_edge, list_checked, node)

n, m, v = map(int, input('').split(' '))

list_edge=[[] for i in range(n+1)]
for i in range(m):

    node1, node2 = map(int, input('').split(' '))

    list_edge[node1].append(node2)
    list_edge[node2].append(node1)

for i in range(len(list_edge)):
    list_edge[i].sort()

# DFS 초기화
list_checked=[False for i in range(n+1)]
list_checked[v] = True
# dfs(list_edge, list_checked, v)

stack = deque()
stack.append(v)

print(v, end=' ')
while True:
    if len(stack)==0:
        break

    curr = stack[len(stack)-1]

    not_leaf = False
    for node in list_edge[curr]:

        # 방문
        if not list_checked[node]:
            print(node, end=' ')
            stack.append(node)
            list_checked[node] = True
            not_leaf = True
            break
    
    if not not_leaf:
        stack.pop()

print('')

# BFS 초기화
queue = deque()
queue.append(v)

list_checked=[False for i in range(n+1)]
list_checked[v] = True

while True:
    if len(queue)==0:
        break

    curr = queue.popleft()
    print(curr, end=' ')
    for node in list_edge[curr]:
        if not list_checked[node]:
            list_checked[node] = True
            queue.append(node)