- 출처 : [https://www.acmicpc.net/problem/2352](https://www.acmicpc.net/problem/2352)

- 알고리즘 : LIS, DP, 이진탐색, lower_bound

- DP만 이용한 풀이 : O(N^2), pypy3 통과
    1. 모든 수를 순회
    2. length_list에 각 인덱스를 마지막으로 하는 촤장 거리 저장
    3. 매 인덱스마다 length_list 순회

- DP+이진탐색을 이용한 풀이 : O(NlogN), python3 통과
    1.  LIS 리스트 set
    2. 모든 수를 순회
    3. lower_bound를 이용해 LIS에서 현재 수 보다 같거나 큰 위치를 찾음
    4. 이미 수가 존재하면 갱신
    5. 아니면 추가

- 소감
    - LIS, lower bound, upper bound 추가 공부 필요