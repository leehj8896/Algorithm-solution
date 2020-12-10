import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())

# input
list_input = []
for i in range(n):

    list_input.append(int(sys.stdin.readline().rstrip()))


# set list smaller than 0
list_low = [m for m in list_input if m <= 0]
dq_low = deque(sorted(list_low))

result = 0

while len(dq_low) > 0:
    tmp1 = 1
    tmp2 = 1

    if len(dq_low) > 0:
        tmp1 = dq_low.popleft()

    if len(dq_low) > 0:
        tmp2 = dq_low.popleft()

    result += tmp1 * tmp2


# set list bigger than 0
list_high = [m for m in list_input if m > 0]
dq_high = deque(sorted(list_high, reverse=True))

while True:

    if len(dq_high) > 0:

        tmp1 = dq_high.popleft()

        if len(dq_high) > 0:
            tmp2 = dq_high.popleft()

            if tmp2 == 1:
                result += tmp1 + tmp2
            else:
                result += tmp1 * tmp2
                
        else:
            result += tmp1
            break

    else:
        break

print(result)