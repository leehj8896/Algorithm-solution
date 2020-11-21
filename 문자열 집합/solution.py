n, m = map(int, input('').split(' '))

set_str = set()
for i in range(n):
    set_str.add(input(''))

count = 0
for i in range(m):
    if input('') in set_str:
        count += 1

print(count)