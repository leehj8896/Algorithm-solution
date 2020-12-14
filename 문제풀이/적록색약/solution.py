import sys

def make_counted_true(board, counted, pos):

    counted[pos['i']][pos['j']] = True

    for d in ['left','right','up','down']:

        new_pos = get_new_position(pos, d)
        if (new_pos['i'] >= 0 and new_pos['i'] < len(board)) and (new_pos['j'] >= 0 and new_pos['j'] < len(board)):
            if not counted[new_pos['i']][new_pos['j']]:
                if board[pos['i']][pos['j']] == board[new_pos['i']][new_pos['j']]:
                    make_counted_true(board, counted, new_pos)


def get_new_position(pos, direction):

    if direction == 'up':
        return {'i': pos['i']-1, 'j': pos['j']}
    if direction == 'down':
        return {'i': pos['i']+1, 'j': pos['j']}
    if direction == 'left':
        return {'i': pos['i'], 'j': pos['j']+1}
    if direction == 'right':
        return {'i': pos['i'], 'j': pos['j']-1}


def print_line(list_line):
    for line in list_line:
        print(line)
    print('')


def get_part_count(board):

    counted = [[False for j in range(len(board))] for i in range(len(board))]
    count = 0

    for i in range(len(board)):
        for j in range(len(board)):

            if not counted[i][j]:
                count += 1
                make_counted_true(board, counted, {'i': i, 'j': j})

    return count


def get_input():

    origin_board = []
    changed_board = []
    n = int(input(''))

    for i in range(n):

        temp = input('')
        origin_board.append(list(temp))
        changed_board.append(list(temp.replace('R', 'G')))

    return n, origin_board, changed_board

sys.setrecursionlimit(99999)

# get_input()
n, origin_board, changed_board = get_input()

origin_count = get_part_count(origin_board)
changed_count = get_part_count(changed_board)

print(origin_count, changed_count)