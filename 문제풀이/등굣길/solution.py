def solution(width, height, list_water):
    
    list_route=[[0 for j in range(width+1)] for i in range(height+1)]
    list_route[1][1]=1

    for i in range(1,height+1):
        for j in range(1,width+1):

            if i==1 and j==1:
                continue
            
            if [j,i] not in list_water:
                list_route[i][j]=list_route[i-1][j]+list_route[i][j-1]

    return list_route[height][width] % 1000000007