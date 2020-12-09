def solution(triangle):

    sum_tri=[[0 for j in range(len(triangle[i]))] for i in range(len(triangle))]

    for i in range(len(triangle)):
        for j in range(len(triangle[i])):
            sum_tri[i][j]=triangle[i][j]
            temp=[]
            if i-1>=0 and i-1<len(triangle) and j>=0 and j<len(triangle[i-1]):
                temp.append(sum_tri[i-1][j])
            if i-1>=0 and i-1<len(triangle) and j-1>=0 and j-1<len(triangle[i-1]):
                temp.append(sum_tri[i-1][j-1])
            if len(temp)>0:
                sum_tri[i][j]+=max(temp)

    return max(sum_tri[len(sum_tri)-1])

print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))