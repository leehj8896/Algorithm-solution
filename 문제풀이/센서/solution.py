def init():
    n = int(input(''))
    k = int(input(''))
    sensor_list = list(map(int, input('').split(' ')))
    return n, k, sensor_list

n, k, sensor_list = init()

sensor_list.sort()

# 모든 센서들 간의 거리 저장
dist_list = []
for i in range(n-1):
    dist_list.append(sensor_list[i+1] - sensor_list[i])

dist_list.sort()

# 큰 순서로 k-1개 삭제
for i in range(k-1):
    if len(dist_list) > 0:
        dist_list.pop()

print(sum(dist_list))