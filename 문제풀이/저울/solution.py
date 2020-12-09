import sys

sys.setrecursionlimit(3000)

n = input('')

def possible(idx, list_weight, used):

    if idx == 0:
        return True
    if idx < 0:
        return False

    for i in range(len(used)):

        if not used[i]:
            used[i] = True
            if possible(idx-list_weight[i], list_weight, used):
                return True
            used[i] = False

    return False
    

list_weight = list(map(int, input('').split(' ')))
used = [False for i in list_weight]

idx = 1
while True:
    print(idx)
    if possible(idx, list_weight, used):
        idx += 1
        continue
    else:
        print(idx)
        break
