def left(board, rpos, bpos):

    if rpos[1] < bpos[1]:
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]][rpos[1]-1] == '#':
                break
            rpos[1] -= 1
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]][bpos[1]-1] == '#':
                break
            if rpos[0] == bpos[0] and rpos[1] == bpos[1]-1:
                if board[bpos[0]][bpos[1]-1] != 'O':
                    break
            bpos[1] -= 1
    else:
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]][bpos[1]-1] == '#':
                break
            bpos[1] -= 1
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]][rpos[1]-1] == '#':
                break
            if rpos[0] == bpos[0] and rpos[1]-1 == bpos[1]:
                if board[rpos[0]][rpos[1]-1] != 'O':
                    break
            rpos[1] -= 1

def up(board, rpos, bpos):

    if bpos[0] > rpos[0]:
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]-1][rpos[1]] == '#':
                break
            rpos[0] -= 1
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]-1][bpos[1]] == '#':
                break
            if rpos[0] == bpos[0]-1 and rpos[1] == bpos[1]:
                if board[bpos[0]-1][bpos[1]] != 'O':
                    break
            bpos[0] -= 1
    else:
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]-1][bpos[1]] == '#':
                break
            bpos[0] -= 1
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]-1][rpos[1]] == '#':
                break
            if rpos[0]-1 == bpos[0] and rpos[1] == bpos[1]:
                if board[rpos[0]-1][rpos[1]] != 'O':
                    break
            rpos[0] -= 1

def down(board, rpos, bpos):

    if rpos[0] > bpos[0]:
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]+1][rpos[1]] == '#':
                break
            rpos[0] += 1
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]+1][bpos[1]] == '#':
                break
            if rpos[0] == bpos[0]+1 and rpos[1] == bpos[1]:
                if board[bpos[0]+1][bpos[1]] != 'O':
                    break
            bpos[0] += 1
    else:
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]+1][bpos[1]] == '#':
                break
            bpos[0] += 1
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]+1][rpos[1]] == '#':
                break
            if rpos[0]+1 == bpos[0] and rpos[1] == bpos[1]:
                if board[rpos[0]+1][rpos[1]] != 'O':
                    break
            rpos[0] += 1

def right(board, rpos, bpos):

    if bpos[1] < rpos[1]:
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]][rpos[1]+1] == '#':
                break
            rpos[1] += 1
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]][bpos[1]+1] == '#':
                break
            if rpos[0] == bpos[0] and rpos[1] == bpos[1]+1:
                if board[bpos[0]][bpos[1]+1] != 'O':
                    break
            bpos[1] += 1
    else:
        # move blue
        while True:
            if board[bpos[0]][bpos[1]] == 'O':
                break
            if board[bpos[0]][bpos[1]+1] == '#':
                break
            bpos[1] += 1
        # move red
        while True:
            if board[rpos[0]][rpos[1]] == 'O':
                break
            if board[rpos[0]][rpos[1]+1] == '#':
                break
            if rpos[0] == bpos[0] and rpos[1]+1 == bpos[1]:
                if board[rpos[0]][rpos[1]+1] != 'O':
                    break
            rpos[1] += 1

def recursion(idx, list_result, list_temp):

    if idx == 10:
        result = [t for t in list_temp]
        list_result.append(result)
        return

    list_temp[idx] = 'l'
    recursion(idx+1, list_result, list_temp)
    list_temp[idx] = 'r'
    recursion(idx+1, list_result, list_temp)
    list_temp[idx] = 'u'
    recursion(idx+1, list_result, list_temp)
    list_temp[idx] = 'd'
    recursion(idx+1, list_result, list_temp)

# set board
board = []
n, m = map(int, input('').split(' '))
for i in range(n):
    board.append(list(input('')))

rpos = [-1, -1]
bpos = [-1, -1]
opos = [-1, -1]

# find position
for i in range(n):
    for j in range(m):
        
        if board[i][j] == 'R':
            rpos[0] = i
            rpos[1] = j

        if board[i][j] == 'B':
            bpos[0] = i
            bpos[1] = j

        if board[i][j] == 'O':
            opos[0] = i
            opos[1] = j


list_temp = ['' for i in range(10)]
list_result = []
recursion(0, list_result, list_temp)

list_count = []

for line in list_result:

    tempr = [rpos[0], rpos[1]]
    tempb = [bpos[0], bpos[1]]

    for i in range(len(line)):
        
        if line[i] == 'l':
            left(board, tempr, tempb)
            if (tempr[0] == opos[0] and tempr[1] == opos[1]) and \
                not (tempb[0] == opos[0] and tempb[1] == opos[1]):
                
                list_count.append(i+1)
                break

        elif line[i] == 'r':
            right(board, tempr, tempb)
            if (tempr[0] == opos[0] and tempr[1] == opos[1]) and \
                not (tempb[0] == opos[0] and tempb[1] == opos[1]):
                
                list_count.append(i+1)
                break
        elif line[i] == 'u':
            up(board, tempr, tempb)
            if (tempr[0] == opos[0] and tempr[1] == opos[1]) and \
                not (tempb[0] == opos[0] and tempb[1] == opos[1]):
                
                list_count.append(i+1)
                break
        elif line[i] == 'd':
            down(board, tempr, tempb)
            if (tempr[0] == opos[0] and tempr[1] == opos[1]) and \
                not (tempb[0] == opos[0] and tempb[1] == opos[1]):
                
                list_count.append(i+1)
                break
    
if len(list_count) > 0:
    print(min(list_count))
else:
    print(-1)