def solution(n):
    answer = 0

    i = 1

    while True:
        s = sum(range(0, i))

        if (n - s) // i < 1:
            break

        if (n - s) % i == 0:
            answer += 1

        i += 1

    return answer