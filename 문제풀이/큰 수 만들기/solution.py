def solution(number, k):

    list_result=[]
    for i in range(len(number)):

        while True:

            if len(list_result)==0:
                list_result.append(number[i])
                break
            elif list_result[len(list_result)-1] < number[i]:
                if k>0:
                    list_result.pop()
                    k-=1
                else:
                    list_result.append(number[i])
                    break

            else:
                list_result.append(number[i])
                break

    for i in range(k):
        list_result.pop()

    return ''.join(list_result)

print(solution('123456789', 8))