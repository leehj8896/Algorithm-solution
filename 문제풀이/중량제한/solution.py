import sys
from collections import deque

def bfs(min_cost):
    q = deque()
    q.append(start_vertex)
    visited = [False] * (vertex_num + 1)
    visited[start_vertex] = True
    while len(q) > 0:
        curr = q.pop()
        # 도착했을 경우
        if curr == end_vertex:
            return True
        for vertex, cost in edge_list[curr]:
            if not visited[vertex]:
                # min_cost 이상일 경우
                if min_cost <= cost:
                    # 이동
                    visited[vertex] = True
                    q.append(vertex)
    return False


def binary_search(low, high):
    # low가 high를 초과했을 경우 값이 작은 high 리턴
    if high < low:
        return high
    mid = (low + high) // 2
    # min_cost == mid 일 때 도착 가능할 경우
    if bfs(mid):
        return binary_search(mid + 1, high)
    # min_cost == mid 일 때 도착 불가능할 경우
    else:
        return binary_search(low, mid - 1)


# init
vertex_num, edge_num = map(int, sys.stdin.readline().rstrip().split(' '))
edge_list = [[] for i in range(vertex_num + 1)]
for i in range(edge_num):
    a,b,c = map(int, sys.stdin.readline().rstrip().split(' '))
    edge_list[a].append([b,c])
    edge_list[b].append([a,c])
start_vertex, end_vertex = map(int, sys.stdin.readline().rstrip().split(' '))

print(binary_search(0, 1000000000))