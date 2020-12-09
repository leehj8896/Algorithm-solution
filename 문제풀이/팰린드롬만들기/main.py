#단어 입력
word = input()
letters = list(word)

#각 character의 개수 세기
dic = {}
for i in letters:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1


sortedKeys = sorted(dic.keys())
oddCount = 0          #홀수개수
oddLetter = ''        #홀수단어

for i in sortedKeys:
    #개수가 홀수일때
    if dic[i] % 2 == 1:
        oddCount += 1
        oddLetter = i
        #개수가 홀수개인 character가 2개 이상이면 실패 
        if oddCount >= 2:
            print("I'm Sorry Hansoo")
            break

#가능할 때
if oddCount < 2:
    #홀수인거 하나 뺌 
    if oddLetter != '' and dic[oddLetter] == 1:
        sortedKeys.remove(oddLetter)

    #오름차순으로 출력 
    for i in sortedKeys:
        print(i * int(dic[i] / 2), end = '')

    #홀수개인 단어 출력 
    if oddLetter != '':
        print(oddLetter, end = '')

    #내림차순으로 출력 
    for i in reversed(sortedKeys):
        print(i * int(dic[i] / 2), end = '')
