from collections import deque
import sys


def 초기화():
    사대수, 동물수, 사정거리 = map(int, sys.stdin.readline().rstrip().split(' '))
    사대리스트 = list(map(int, sys.stdin.readline().rstrip().split(' ')))
    동물리스트 = []
    for i in range(동물수):
        x, y = map(int, sys.stdin.readline().rstrip().split(' '))
        동물리스트.append([x, y])
    잡은수 = [0]
    return 사대수, 동물수, 사정거리, 사대리스트, 동물리스트, 잡은수


def 왼쪽잡기():
    첫사대 = 사대데크[0]
    현재동물 = 동물데크.popleft()
    while True:
        if 현재동물[0] < 첫사대:
            if 첫사대-현재동물[0] + 현재동물[1] <= 사정거리:
                잡은수[0] += 1
            if len(동물데크) > 0:
                현재동물 = 동물데크.popleft()
            else:
                break
        else:
            동물데크.appendleft(현재동물)
            break


def 오른쪽잡기():
    마지막사대 = 오른쪽사대
    현재동물 = 동물데크.popleft()
    while True:
        if 마지막사대 <= 현재동물[0]:
            if 현재동물[0]-마지막사대 + 현재동물[1] <= 사정거리:
                잡은수[0] += 1
            if len(동물데크) > 0:
                현재동물 = 동물데크.popleft()
            else:
                break
        else:
            break


사대수, 동물수, 사정거리, 사대리스트, 동물리스트, 잡은수 = 초기화()

사대리스트.sort()
동물리스트.sort(key=lambda x: (x[0], x[1]))

사대데크 = deque(사대리스트)
동물데크 = deque(동물리스트)

왼쪽잡기()

# 가운데잡기
왼쪽사대 = 사대데크.popleft()
오른쪽사대 = 왼쪽사대
if len(사대데크) > 0:
    오른쪽사대 = 사대데크.popleft()
동물 = 동물데크.popleft()
while True:
    if 왼쪽사대 == 동물[0]:
        if 동물[1] <= 사정거리:
            잡은수[0] += 1
        if len(동물데크) > 0:
            동물 = 동물데크.popleft()
        else:
            break
    elif 왼쪽사대 < 동물[0] < 오른쪽사대:
        if 동물[0]-왼쪽사대 < 오른쪽사대-동물[0]:
            if 동물[0]-왼쪽사대 + 동물[1] <= 사정거리:
                잡은수[0] += 1
        else:
            if 오른쪽사대-동물[0] + 동물[1] <= 사정거리:
                잡은수[0] += 1
        if len(동물데크) > 0:
            동물 = 동물데크.popleft()
        else:
            break
    else:
        if len(사대데크) > 0:
            왼쪽사대 = 오른쪽사대
            오른쪽사대 = 사대데크.popleft()
        else:
            동물데크.appendleft(동물)
            break

if len(동물데크)>0:
    오른쪽잡기()

print(잡은수[0])
