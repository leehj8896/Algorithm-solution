from collections import deque
import heapq


def dijkstra(start):
    dist_list = [float('inf')] * (n+1)
    dist_list[start] = 0
    hq = []
    heapq.heappush(hq, (0, start))
    # processed = [False] * (n+1)
    while hq:
        w, a = heapq.heappop(hq)
        # if processed[a]:
        #     continue
        # processed[a] = True
        for u in adj_list[a]:
            b, w = u
            if dist_list[b] > dist_list[a] + w:
                dist_list[b] = dist_list[a] + w
                heapq.heappush(hq, (w, b))
    return dist_list


def init():
    import sys
    ipt = sys.stdin.readline
    n, e = map(int, ipt().split())
    adj_list = [[] for _ in range(n+1)]
    for _ in range(e):
        a, b, c = map(int, ipt().split())
        adj_list[a].append((b, c))
        adj_list[b].append((a, c))
    goal1, goal2 = map(int, ipt().split())
    return n, adj_list, goal1, goal2


n, adj_list, goal1, goal2 = init()
dist_list1 = dijkstra(1)
dist_list2 = dijkstra(goal1)
dist_list3 = dijkstra(goal2)
dist1 = dist_list1[goal1] + dist_list2[goal2] + dist_list3[n]
dist2 = dist_list1[goal2] + dist_list3[goal1] + dist_list2[n]
if min(dist1, dist2) == float('inf'):
    print(-1)
else:
    print(min(dist1, dist2))