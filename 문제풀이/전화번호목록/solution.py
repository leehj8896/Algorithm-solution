# 백준

import sys

testcase = int(input(''))

for t in range(testcase):

    pn_list = []

    num = int(input(''))
    for n in range(num):

        phone_number = sys.stdin.readline().rstrip()
        pn_list.append(phone_number)
    
    pn_list.sort()

    result = True
    for i in range(num-1):

        if pn_list[i+1].startswith(pn_list[i]):
            result = False
            break

    if result:
        print('YES')
    else:
        print('NO')