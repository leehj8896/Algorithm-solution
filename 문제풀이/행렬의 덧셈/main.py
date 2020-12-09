def solution(arr1, arr2):
    ilen=len(arr1)
    jlen=len(arr1[0])

    answer=[[0 for j in range(jlen)] for i in range(ilen)]

    for i in range(len(arr1)):
        for j in range(len(arr1[0])):
            answer[i][j]=arr1[i][j]+arr2[i][j]
    return answer