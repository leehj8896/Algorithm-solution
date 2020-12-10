import math

def solution(n):
    answer = 0

    sqrt=math.sqrt(n)
    if sqrt-int(sqrt)==0:
        return int(math.pow(sqrt+1, 2))
    else:
        return -1

if __name__ == "__main__":
    print(
        solution(
            3
        )
    )