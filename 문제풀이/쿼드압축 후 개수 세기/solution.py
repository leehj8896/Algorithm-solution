def solution(arr):

    list_result = [0, 0]
    set_count(list_result, arr)

    return list_result

def set_count(list_result, arr):

    if all0(arr):
        list_result[0] += 1
        return
    if all1(arr):
        list_result[1] += 1
        return

    set_count(list_result, [line[:len(line)//2] for line in arr[:len(arr)//2]])
    set_count(list_result, [line[len(line)//2:] for line in arr[:len(arr)//2]])
    set_count(list_result, [line[:len(line)//2] for line in arr[len(arr)//2:]])
    set_count(list_result, [line[len(line)//2:] for line in arr[len(arr)//2:]])

    pass

def all0(arr):

    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if arr[i][j] == 1:
                return False
    return True

def all1(arr):

    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if arr[i][j] == 0:
                return False
    return True