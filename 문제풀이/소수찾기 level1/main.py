def solution(n):
    answer = 0

    isPrime=[True for i in range(n+1)]
    isPrime[0]=False
    isPrime[1]=False

    for i in range(len(isPrime)):

        if isPrime[i]==False:
            continue

        # i의 배수 인덱스를 False로 바꾸는 함수
        change(isPrime, i)

    answer=countTrue(isPrime)

    return answer

def change(isPrime, idx):

    i=2
    while True:
        
        if idx*i>=len(isPrime):
            break
        isPrime[idx*i]=False
        
        i+=1

def countTrue(isPrime):

    result=0
    for b in isPrime:
        if b:
            result+=1
    return result

if __name__ == "__main__":
    
    n=5
    print(
        solution(5)
    )