def solution(strings, n):
    return sorted(strings, key=lambda text: (text[n], text))

if __name__ == "__main__":
    
    strings=[
        'sun',
        'bed',
        'car',
    ]
    n=1

    print(solution(strings, n))