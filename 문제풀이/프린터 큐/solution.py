from collections import deque

testcase = int(input(''))

for i in range(testcase):

    list_tmp = list(map(int, input('').split(' ')))
    n=list_tmp[0]
    m=list_tmp[1]

    list_tmp = list(map(int, input('').split(' ')))

    dq=deque(
        [{'num':i, 'weight':list_tmp[i]} for i in range(n)]
    )

    count=1
    while True:

        int_max=max(dq, key=lambda x: x['weight'])
        finished=False
        while True:

            dict_tmp=dq.popleft()

            if dict_tmp['weight']==int_max['weight']:
                if dict_tmp['num']==m:
                    print(count)
                    finished=True
                count+=1
                break
            else:
                dq.append(dict_tmp)
        
        if finished:
            break
        