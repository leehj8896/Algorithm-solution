def solution(s):
    answer = ''

    list_word=s.split(' ')

    for i in range(len(list_word)):
        temp=''
        for j in range(len(list_word[i])):
            if j%2==0:
                temp+=list_word[i][j].upper()
            else:
                temp+=list_word[i][j].lower()
        list_word[i]=temp

    return ' '.join(list_word)