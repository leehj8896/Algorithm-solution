def findMin(arr, minIndex, maxIndex):
    length = len(arr)
    index = maxIndex
    for i in range(length):
        if arr[minIndex][1] <= arr[i][0] and arr[i][1] < arr[index][1]:
            index = i
    return index

n = int(input())
table = []
minIndex = 0
maxIndex = 0
for i in range(n):
    temp = input().split()
    integers = [int(temp[0]), int(temp[1])]
    table.append(integers)
    if table[maxIndex][1] < integers[1]:
        maxIndex = i
    if table[minIndex][1] > integers[1]:
        minIndex = i 

result = [table[minIndex]]
while True:
    
    nextIndex = findMin(table, minIndex, maxIndex)    
    result.append(table[nextIndex])
    minIndex = nextIndex

    if nextIndex == maxIndex:
        break

print(len(result))