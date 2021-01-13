import sys


def 초기화():
    지점개수, 도로개수, 웜홀개수 =  map(int, sys.stdin.readline().split())
    연결리스트 = []
    for _ in range(도로개수):
        출발지, 도착지, 시간 =  map(int, sys.stdin.readline().split(' '))
        연결리스트.append((출발지, 도착지, 시간))
        연결리스트.append((도착지, 출발지, 시간))
    for _ in range(웜홀개수):
        출발지, 도착지, 시간 =  map(int, sys.stdin.readline().split())
        연결리스트.append((출발지, 도착지, -시간))
    return 지점개수, 도로개수, 웜홀개수, 연결리스트


def 음수사이클(지점개수, 연결리스트):
    # float('inf')로 초기화하면 틀림
    거리리스트 = [999999 for _ in range(지점개수+1)]
    거리리스트[1] = 0
    for _ in range(지점개수):
        for 출발지, 도착지, 시간 in 연결리스트:
            거리리스트[도착지] = min(거리리스트[도착지], 거리리스트[출발지] + 시간)
    for 출발지, 도착지, 시간 in 연결리스트:
        if 거리리스트[도착지] > 거리리스트[출발지] + 시간:
            return True
    return False
        

테스트케이스 = int(sys.stdin.readline())
for _ in range(테스트케이스):
    지점개수, 도로개수, 웜홀개수, 연결리스트 = 초기화()
    if 음수사이클(지점개수, 연결리스트):
        print('YES')
    else:
        print('NO')
