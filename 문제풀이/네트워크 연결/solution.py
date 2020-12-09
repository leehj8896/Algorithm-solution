import sys

def get_index(list_cut, node):

    for i in range(len(list_cut)):
        if node in list_cut[i]:
            return i

    return -1

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

list_cut = [{i} for i in range(1, n+1)]

list_edge = []
for i in range(m):

    a, b, c = map(int, sys.stdin.readline().rstrip().split(' '))
    list_edge.append([a,b,c])

list_edge.sort(key=lambda x: x[2])

result = 0
for edge in list_edge:

    idx1 = get_index(list_cut, edge[0])
    idx2 = get_index(list_cut, edge[1])

    if idx1 != idx2:
        result += edge[2]
        list_cut[idx1] = list_cut[idx1] | list_cut[idx2]
        list_cut.pop(idx2)

print(result)