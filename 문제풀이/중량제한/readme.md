- 출처 : [https://www.acmicpc.net/problem/1939](https://www.acmicpc.net/problem/1939)

- 알고리즘 : 이진 탐색, 너비 우선 순회

- 풀이
    1. set 에지 연결 리스트
    2. BFS in 이진 탐색

- 이진 탐색 구현
    1. mid = (low + high) // 2 
    2. mid 이상인 cost로 출발지부터 도착지까지 갈 수 있을 경우(BFS)
        1. low = mid + 1
    3. 갈 수 없을 경우
        1. high = mid - 1

- BFS 구현
    1. 전형적인 BFS에서
    2. 최소 cost (mid) ≤ 현재 에지 cost 일 경우 이동

- 소감
    - 처음에 DFS로 모든 경로를 찾아 cost의 최솟값의 최댓값을 찾으려 했다
    - 시간 초과가 났다
    - 풀이를 참고했으나 BFS구현에서 자꾸 틀렸다
    - 이진 탐색으로 최소 cost를 찾아나가야 하는데 최대 cost를 찾고 있었다