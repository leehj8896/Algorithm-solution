# 동적계획법: O(N^2)
def init():
    port_num = int(input(''))
    port_list = list(map(int, input('').split(' ')))
    return port_num, port_list


port_num, port_list = init()
length_list = [0] * port_num
for i in range(port_num):
    length_list[i] = 1
    for j in range(i):
        if port_list[j] < port_list[i]:
            length_list[i] = max(length_list[i], length_list[j]+1)
print(max(length_list))
