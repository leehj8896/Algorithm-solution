- 출처 : [연구소](https://www.acmicpc.net/problem/14502)

- 풀이방법 : 완전탐색 / DFS / 재귀

- 순서
    1. board에서 값이 0인 좌표 중 3개 선택 (Combinations)
    2. 각 조합마다 2와 속해 있는 구역을 2로 채움 (DFS)
    3. 0 개수를 카운트
    4. 최댓값 출력

- 소감 : 수월했다