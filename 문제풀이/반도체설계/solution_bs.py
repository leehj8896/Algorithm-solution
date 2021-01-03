# 동적계획법 + 이분탐색: O(NlogN)
def binary_search(start, end, key):
    if start > end:
        return start
    mid = (start+end)//2
    if key > num_list[mid]:
        return binary_search(mid+1, end, key)
    if key <= num_list[mid]:
        return binary_search(start, mid-1, key)


def init():
    port_num = int(input(''))
    port_list = list(map(int, input('').split(' ')))
    return port_num, port_list


port_num, port_list = init()
num_list = [port_list[0]]
for i in range(1, port_num):
    j = binary_search(0, len(num_list)-1, port_list[i])
    if j < len(num_list):
        num_list[j] = port_list[i]
    else:
        num_list.append(port_list[i])
print(len(num_list))
