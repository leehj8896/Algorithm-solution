sn, sk = input().split()
n = int(sn)
k = int(sk)
a = []

# 0 1 2 3 4
j = 0
for i in range(n):
    temp = int(input())
    a.append(temp)
    if temp < k:
        j = i
    
# print("j =", j)

count = 0
while j >= 0:
    count += k // a[j]
    k = k % a[j]
    j -= 1

print(count)