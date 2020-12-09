def solution(n, number):

    list_set=[]
    for i in range(9):
        temp=set([])
        temp.add(str(n)*i)
        list_set.append(temp)

    for i in range(2,9):
        for j in range(1, i):

            for e1 in list_set[j]:
                for e2 in list_set[i-j]:
                    list_set[i].add(str(int(e1)+int(e2)))
                    list_set[i].add(str(int(e1)-int(e2)))
                    list_set[i].add(str(int(e1)*int(e2)))
                    if int(e2)!=0:
                        list_set[i].add(str(int(int(e1)/int(e2))))

    for i in range(1, 8+1):
        if str(number) in list_set[i]:
            return i

    return -1

print(
    solution(5, 12)
)