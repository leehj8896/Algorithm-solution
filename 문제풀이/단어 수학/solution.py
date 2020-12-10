n = int(input(''))

list_dict = [dict() for i in range(8)]

for i in range(n):
    list_curr = list(input(''))
    
    idx = 0
    while len(list_curr) > 0:
        curr = list_curr.pop()
        if curr in list_dict[idx]:
            list_dict[idx][curr] += 1
        else:
            list_dict[idx][curr] = 1

        idx += 1

# print(list_dict)

dict_result = dict()
for i in range(0, 8):
    for key in list_dict[i]:
        
        if key in dict_result:
            dict_result[key] += list_dict[i][key] * pow(10, i)
        else:
            dict_result[key] = list_dict[i][key] * pow(10, i)

# print(dict_result)

# print(type(dict_result.items()))
# for x in dict_result.items():
#     print(type(x))

list_result = sorted(
    [(key, dict_result[key]) for key in dict_result],
    key=lambda x:x[1],
    reverse=True
)

print(list_result)

result = 0
num = 9
for tuple_r in list_result:

    result += tuple_r[1] * num

    num -= 1

print(result)