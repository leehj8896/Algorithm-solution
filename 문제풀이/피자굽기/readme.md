- 출처 : [[백준 1756] 피자 굽기](https://www.acmicpc.net/problem/1756)

- 알고리즘 : 이진 탐색

- 풀이
    1. 정렬 ([https://n-square.tistory.com/21](https://n-square.tistory.com/21))

        ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8e1fa19d-05c0-4103-934e-61e93022379f/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8e1fa19d-05c0-4103-934e-61e93022379f/Untitled.png)

    2. 이진 탐색

- 이진 탐색 구현 방법
    - 재귀 함수
    - middle 값에 도우가 들어가고 middle+1에 들어가지 않을 때 return

- 소감
    - O(N^2)은 당연히 안될 것 같아서 시도를 안 했다
    - O(N)에 정렬하는 방법이 생각이 안 나서 검색 ㅠ
    - 이후에 피자마다 범위를 줄여나갈 때 리스트 슬라이싱 → 시간 초과
        - → limit 값을 넣어 해결
    - 자꾸 오답
        - → 피자가 남아있을 때 end_idx가 0이면 종료
    - 오답인데 통과인 것 같다
    - 등록 안 된 테스트 케이스가 있는 것 같다

        ```python
        7 3
        5 6 4 3 6 2 3
        4 4 4
        답: 1(O) 0(X)
        ```