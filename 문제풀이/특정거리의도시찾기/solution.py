def 초기화():
    import sys
    입력 = sys.stdin.readline
    도시개수, 도로개수, 특정거리, 출발도시 = map(int, 입력().split())
    연결리스트 = []
    for _ in range(도로개수):
        출발지, 도착지 = map(int, 입력().split())
        연결리스트.append((출발지, 도착지))
    return 도시개수, 도로개수, 특정거리, 출발도시, 연결리스트
        

def 거리리스트얻기():
    거리리스트 = [float('inf') for _ in range(도시개수+1)]
    거리리스트[출발도시] = 0
    for _ in range(도시개수):
        for 출발지, 도착지 in 연결리스트:
            거리리스트[도착지] = min(거리리스트[도착지], 거리리스트[출발지]+1)
    return 거리리스트


도시개수, 도로개수, 특정거리, 출발도시, 연결리스트 = 초기화()
거리리스트 = 거리리스트얻기()
결과리스트 = []
for 도착지 in range(1, 도시개수+1):
    if 거리리스트[도착지] == 특정거리:
        결과리스트.append(str(도착지))
if len(결과리스트):
    print('\n'.join(sorted(결과리스트)))
else:
    print(-1)