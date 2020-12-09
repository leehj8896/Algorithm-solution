def go(room, r, c, d):

    room[r][c] = 1

    global result
    result += 1

    count = 0
    while True:

        d = get_left(d)
        # N
        if d == 0:
            if room[r-1][c] == 0:
                go(room, r-1, c, d)
                break
            else:
                count += 1
        # E
        if d == 1:
            if room[r][c+1] == 0:
                go(room, r, c+1, d)
                break
            else:
                count += 1
        # S
        if d == 2:
            if room[r+1][c] == 0:
                go(room, r+1, c, d)
                break
            else:
                count += 1
        # W
        if d == 3:
            if room[r][c-1] == 0:
                go(room, r, c-1, d)
                break
            else:
                count += 1

        if count == 4:
            # N
            if d == 0:
                if room[r+1][c] == 0:
                    go(room, r+1, c, d)
            # E
            if d == 1:
                if room[r][c-1] == 0:
                    go(room, r, c-1, d)
            # S
            if d == 2:
                if room[r-1][c] == 0:
                    go(room, r-1, c, d)
            # W
            if d == 3:
                if room[r][c+1] == 0:
                    go(room, r, c+1, d)
            break

def get_left(d):

    # N
    if d == 0:
        return 3
    # E
    if d == 1:
        return 0
    # S
    if d == 2:
        return 1
    # W
    if d == 3:
        return 2


# Init
h, w = map(int, input('').split(' '))
r, c, d = map(int, input('').split(' '))
room = []
for i in range(h):
    room.append(list(map(int, input('').split(' '))))

while True:
    room[r][c] = 1
    d = get_left(d)

    # N
    if d == 0:
        if room[r-1][c] == 0:
            continue
        else:
            count += 1
    # E
    if d == 1:
        if room[r][c+1] == 0:
            continue
        else:
            count += 1
    # S
    if d == 2:
        if room[r+1][c] == 0:
            continue
        else:
            count += 1
    # W
    if d == 3:
        if room[r][c-1] == 0:
            continue
        else:
            count += 1
