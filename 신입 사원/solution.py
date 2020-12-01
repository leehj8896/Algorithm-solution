import sys

testcase = int(sys.stdin.readline().rstrip())
for t in range(testcase):
    
    list_player = []
    n = int(sys.stdin.readline().rstrip())
    for i in range(n):

        rank1, rank2 = map(int, sys.stdin.readline().rstrip().split(' '))
        list_player.append({
            'rank1':rank1,
            'rank2':rank2,
        })

    list_player.sort(key=lambda x:x['rank1'])
    list_top = [0 for i in range(n)]
    top = n+1
    for i in range(n):
        if list_player[i]['rank2'] < top:
            top = list_player[i]['rank2']
        list_top[i] = top
    
    count = 0
    for i in range(n):
        if list_player[i]['rank2'] == list_top[i]:
            count += 1

    print(count)
