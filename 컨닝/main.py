c = int(input())

for i in range(c):
    nm = input().split()
    n = int(nm[0])
    m = int(nm[1])

    arr = []
    for j in range(n):
        temp = list(input())
        arr.append(temp)
    print(arr)