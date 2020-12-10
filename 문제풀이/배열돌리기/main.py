import copy
from itertools import permutations

#리스트의 행의 합의 최소값을 구하는 함수
def getMin(arr, n):
    result = sum(arr[0])
    for i in range(1, n): 
        temp = sum(arr[i])
        if result > temp:
            result = temp
    return result

#회전된 리스트를 구하는 함수
def getRotate(arr, r, c, s):
    
    resultArr = copy.deepcopy(arr)

    for i in range(1, s + 1):
        
        #위
        for j in range(2 * i):
            resultArr[r-i][c-i+j+1] = arr[r-i][c-i+j]
        #오른
        for j in range(2 * i):
            resultArr[r-i+j+1][c+i] = arr[r-i+j][c+i]
        #아래
        for j in range(2 * i):
            resultArr[r+i][c+i-(j+1)] = arr[r+i][c+i-j]
        #왼
        for j in range(2 * i):
            resultArr[r+i-(j+1)][c-i] = arr[r+i-j][c-i]
        
    return resultArr

n, m, k = map(int, input().split())

#배열 입력
myMap = list(range(n))
for i in range(n):
    myMap[i] = list(map(int, input().split()))

#회전연산 입력
rcs = list(range(k))
for i in range(k):
    rcs[i] = list(map(int, input().split()))

#순열
order = list(permutations(rcs, k))
lengthOfOrder = len(order)

#0번째 경우의 수 회전 연산
tempList = getRotate(myMap, order[0][0][0]-1, order[0][0][1]-1, order[0][0][2])
for j in range(1, k):
    tempList = getRotate(tempList, order[0][j][0]-1, order[0][j][1]-1, order[0][j][2])
minValue = getMin(tempList, n)

#1~n-1번째 경우의 수 회전 연산 후 최소 값
minList = list(range(lengthOfOrder))
for i in range(1, lengthOfOrder):
    tempList = getRotate(myMap, order[i][0][0]-1, order[i][0][1]-1, order[i][0][2])
    for j in range(1, k):
        tempList = getRotate(tempList, order[i][j][0]-1, order[i][j][1]-1, order[i][j][2])
    
    tempValue = getMin(tempList, n)
    if minValue > tempValue:
        minValue = tempValue

print(minValue)