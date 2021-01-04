def get_length(i, j):
    if str1[i] == str2[j]:
        return length_list[i-1][j-1] + 1
    else:
        return max(length_list[i-1][j], length_list[i][j-1])


def init():
    str1 = input('').rstrip()
    str2 = input('').rstrip()
    length_list = [[0 for j in range(len(str2)+1)] for i in range(len(str1)+1)]
    return str1, str2, length_list


str1, str2, length_list = init()
for i in range(len(str1)):
    for j in range(len(str2)):
        length_list[i][j] = get_length(i, j)
print(length_list[len(str1)-1][len(str2)-1])