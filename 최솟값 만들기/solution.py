def solution(list_a, list_b):
    answer = 0

    list_a.sort()
    list_b.sort(reverse=True)

    for i in range(len(list_a)):
        answer += list_a[i] * list_b[i]

    return answer