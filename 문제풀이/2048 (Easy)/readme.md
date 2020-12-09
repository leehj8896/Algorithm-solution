- 출처 : [https://www.acmicpc.net/problem/12100](https://www.acmicpc.net/problem/12100)

- 풀이방법 : 완전탐색

- 순서
    1. 각 시행마다 가능한 4가지 경우(up, down, left, right) 모두 대입
    2. 시행 횟수가 5회 이상일 경우 리스트에 최대값 추가 후 종료
    3. 리스트에서 최대값 출력

- 이동 함수(up, down, right, left) 구현 방법
    1. 각 로우 별로 deque에 append
    2. 값 두개를 popleft한 후 같으면 append
    3. 다르면 하나는 append, 하나는 appendleft
    4. 반복