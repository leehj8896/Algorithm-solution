def get_time():

    # 이동이 불가능할 경우
    if max(box_list) > max(crane_list):
        return -1

    # 내림차순으로 정렬
    crane_list.sort(reverse=True)
    box_list.sort(reverse=True)

    # 각 크레인 별 이동 가능 박스 저장
    crane_dict = dict()
    for i in range(n):
        for j in range(m):

            if crane_list[i] >= box_list[j]:
                if crane_list[i] not in crane_dict:
                    crane_dict[crane_list[i]] = []
                crane_dict[crane_list[i]].append(j)

    answer = 0
    move_count = 0
    moved = [False] * m

    # 모두 다 옮길 때까지 반복
    while move_count < m:

        answer += 1

        # 모든 크레인에 대해
        for i in range(n):
            if crane_list[i] in crane_dict:
                # 이동 가능한 박스 반복
                for j in crane_dict[crane_list[i]]:
                    if not moved[j]:
                        moved[j] = True
                        move_count += 1
                        break

    return answer


n = int(input(''))
crane_list = list(map(int, input('').split(' ')))
m = int(input(''))
box_list = list(map(int, input('').split(' ')))

result = get_time()

print(result)
