import sys
testcase=int(sys.stdin.readline().rstrip())
for _ in range(testcase):
    building_num, order_num = map(int, sys.stdin.readline().rstrip().split(' '))
    time_list = [0] + list(map(int, sys.stdin.readline().rstrip().split(' ')))
    order_list = [[] for i in range(building_num+1)]
    for _ in range(order_num):
        x, y = map(int, sys.stdin.readline().rstrip().split(' '))
        order_list[y].append(x)
    goal=int(sys.stdin.readline().rstrip())
    bfs(goal)