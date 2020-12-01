line = input('')

list_plus = line.split('-')

result = 0
idx = 0
for p in list_plus:

    if idx == 0:
        result += sum(map(int, p.split('+')))
    else:
        result -= sum(map(int, p.split('+')))
    
    idx += 1

print(result)