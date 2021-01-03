def init():
    n, int(input(''))
    port_list = [0] + list(map(int, input('').split(' ')))
    return n,port_list
n, port_list = init()

length_list = [0] * (n+1)
min_list = [float('inf')] * (n+1)
min_list[0] = 0

for i in range(n+1):
    binary_search(0, n+1)