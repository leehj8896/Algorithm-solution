- 출처 : [https://www.acmicpc.net/problem/11054](https://www.acmicpc.net/problem/11054)

- 알고리즘 : DP, LIS

- 풀이
    1. 모든 수열을 돌면서
    2. 현재 원소가 기준 값일 때 증가하는 최장 길이를 구한다
    3. 감소하는 최장 길이는 reversed로 똑같이 구현

- 소감
    - 처음에 보고 엄청 막막했다가 LIS 문제 복잡도 NlogN에서 한 바퀴만 더 돌면 될 것 같아 시도해봤다.
    - 다행히 python3에서도 성공!