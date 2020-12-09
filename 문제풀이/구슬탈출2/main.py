def left(myMap, n, m, y, x, what):
    while x-1 >= 0 and myMap[y][x - 1] == '.':
        myMap[y][x -1] = what
        myMap[y][x] = '.'
        x = x - 1

def right(myMap, n, m, y, x, what):
    while x+1 <= m and myMap[y][x + 1] == '.':
        myMap[y][x + 1] = what
        myMap[y][x] = '.'
        x = x + 1

def up(myMap, n, m, y, x, what):    
    while y + 1 <= n and myMap[y + 1][x] == '.':
        myMap[y+1][x] = what
        myMap[y][x] = '.'
        y = y + 1

def down(myMap, n, m, y, x, what):    
    while y - 1 >= 0 and myMap[y - 1][x] == '.':
        myMap[y-1][x] = what
        myMap[y][x] = '.'
        y = y - 1

nm = input().split()
n = int(nm[0])
m = int(nm[1])

myMap = []
r_position = [-1, -1]
b_position = [-1, -1]
o_position = [-1, -1]
for i in range(n):
    temp = input()
    templist = []
    for j in range(m):
        templist.append(temp[j])
        if temp[j] == 'R':
            r_position = [j, i]
        elif temp[j] == 'B':
            b_position = [j, i]
        elif temp[j] == 'O':
            o_position = [j, i]
    myMap.append(templist)