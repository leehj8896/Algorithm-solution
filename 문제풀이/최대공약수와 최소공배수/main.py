def solution(n, m):
    
    list_num=swap([n, m])

    big=get_big(list_num[0], list_num[1])

    return [big, big * (n/big) * (m/big)]

def swap(list_num):

    if list_num[0]>list_num[1]:
        temp=list_num[0]
        list_num[0]=list_num[1]
        list_num[1]=temp
    return list_num

def get_big(n, m):

    list_yac=[]
    for i in range(1, n+1):
        if n%i==0:
            list_yac.append(i)

    list_yac=sorted(list_yac, reverse=True)

    for i in range(len(list_yac)):
        if m%list_yac[i]==0:
            return list_yac[i]