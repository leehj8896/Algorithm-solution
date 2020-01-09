n = int(input())

#lst = [[0 for i in range(n)] for j in range(n)]
lst = []
for i in range(n):
    temp = input().split()
    templst = []
    for j in range(n):
        templst.append(temp[j])
    lst.append(templst)


for y in range(n):
    f = 0
    t = 0
    
    summed = 0
    for x in range(t, n):
        if lst[y][x] != 0:
            f = x
            break
    for x in range(f, n):
        if lst[y][x] != 0:
            t = x
            break
    
    if lst[y][f] == lst[y][t]:
        summed = lst[y][f] + lst[y][t]
    