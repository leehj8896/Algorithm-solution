def get_left(pos):

    if pos[2] == '북':
        return [pos[0], pos[1]-1, '서']
    elif pos[2] == '서':
        return [pos[0]+1, pos[1], '남']
    elif pos[2] == '남':
        return [pos[0], pos[1]+1, '동']
    elif pos[2] == '동':
        return [pos[0]-1, pos[1], '북']

def get_back(pos):
    
    if pos[2] == '북':
        return [pos[0]+1, pos[1], '북']
    elif pos[2] == '서':
        return [pos[0], pos[1]+1, '서']
    elif pos[2] == '남':
        return [pos[0]-1, pos[1], '남']
    elif pos[2] == '동':
        return [pos[0], pos[1]-1, '동']


n, m = map(int, input('').split(' '))
pos = list(map(int, input('').split(' ')))
if pos[2] == 0:
    pos[2] = '북'
if pos[2] == 1:
    pos[2] = '동'
if pos[2] == 2:
    pos[2] = '남'
if pos[2] == 3:
    pos[2] = '서'
    
board = []
for i in range(n):
    board.append(
        list(map(int, input('').split(' ')))
    )

cleaned = [[False for j in range(m)] for i in range(n)]
# count = [0]


finished = False
result = 0

# 청소
while True:
    
    # clean_here()
    cleaned[pos[0]][pos[1]] = True
    result += 1

    # count_reset_if_go()
    count = 0

    # 회전
    while True:

        new_pos = get_left(pos)

        # left_yet()
        if not cleaned[new_pos[0]][new_pos[1]] and board[new_pos[0]][new_pos[1]] != 1:
            # spin()
            # go()
            pos = new_pos
            count = 0
            break

        else:
            # spin()
            pos[2] = new_pos[2]
            count += 1

            # if count_reset_if_go() > 4:
            if count == 4:
                new_pos = get_back(pos)
                # if can_back():
                if board[new_pos[0]][new_pos[1]] != 1:
                    # back()
                    pos = new_pos
                    count = 0
                else:
                    finished = True
                    break
    if finished:
        break

print(result)