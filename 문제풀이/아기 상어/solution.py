def relax(dist, i, j):

    if i-1 >= 0 and dist[i][j] > dist[i-1][j] + 1:
        dist[i][j] = dist[i-1][j] + 1

    if j-1 >= 0 and dist[i][j] > dist[i][j-1] + 1:
        dist[i][j] = dist[i][j-1] + 1
    
    if j+1 < len(dist) and dist[i][j] > dist[i][j+1] + 1:
        dist[i][j] = dist[i][j+1] + 1
    
    if i+1 < len(dist) and dist[i][j] > dist[i+1][j] + 1:
        dist[i][j] = dist[i+1][j] + 1


n = int(input(''))

result = 0
eat_count = 0

currw = 2
curri = -1
currj = -1

room = []
for i in range(n):
    
    temp = list(map(int, input('').split(' ')))
    room.append(temp)

    if 9 in temp:
        curri = i
        currj = temp.index(9)


while True:

    dist = [[float('inf') for j in range(n)] for i in range(n)]
    dist[curri][currj] = 0

    # set shortest path distance
    for y in range(n):
        for x in range(n):

            for i in range(n):
                for j in range(n):

                    if room[i][j] <= currw:
                        relax(dist, i, j)

    # get min
    mini = -1
    minj = -1
    minv = float('inf')
    for i in range(n):
        for j in range(n):
            if room[i][j] != 9 and room[i][j] != 0 and room[i][j] < currw and minv > dist[i][j]:
                minv = dist[i][j]
                mini = i
                minj = j

    if minv == float('inf'):
        break

    # move
    room[mini][minj] = 9
    room[curri][currj] = 0

    curri = mini
    currj = minj

    result += minv
    eat_count += 1    
    if eat_count == currw:
        currw += 1
        eat_count = 0

print(result)