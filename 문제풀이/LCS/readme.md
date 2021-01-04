- 출처 : [https://www.acmicpc.net/problem/9251](https://www.acmicpc.net/problem/9251)

- 알고리즘 : DP, LCS

- 풀이
    1. 현재 인덱스까지의 최장 공통 길이를 저장하는 2차원 리스트 set
        1. padding을 0으로 준다
    2. 각 인덱스를 순회
    3. 문자열1[i] == 문자열2[j] 이면 최장 길이[i-1][j-1]+ 1
    4. 아니면 max(최장길이[i-1][j], 최장길이[i][j-1])