'''
1
1 2
1 2 3
1 2 3 3
1 2 3 3 4

32
'''

num = int(input())
people = input().split()
changed = [int(i) for i in people]

changed.sort()

result = 0
for i in range(num):
    result += sum(changed[:i+1])
print(result)