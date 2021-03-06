- 출처 : [https://www.acmicpc.net/problem/1613](https://www.acmicpc.net/problem/1613)

- 문제 : 백준 1613번 역사

- 틀린 풀이 : 위상 정렬, DFS
    1. 각 노드를 정렬 (위상 정렬)
    2. 연결되지 않은 노드 분리 (DFS)
    3. 연결된 노드일 경우 정렬된 리스트에서 인덱스 비교하여 1 또는 -1 출력
    4. 연결되지 않았을 경우 0 출력

- 틀린 이유 : 연결되어 있지만 관계를 모르는 경우가 존재  
    ![image](https://user-images.githubusercontent.com/28583563/104286494-75ce2980-54f8-11eb-9be9-0ace0933d311.png)

- 맞은 풀이 : Floyd-Warshall, DP
    1. 2차원 거리 리스트 초기화
    2. 리스트[k][i][j] : 1부터 k까지의 노드만을 지나 i에서 j까지 도달하는 거리
    3. 모든 노드 간 거리 계산(N^2)을 N번 반복(3중 for문)
        - 계산법 : 리스트[i][j] = min(리스트[i][j], 리스트[i][k]+리스트[k][j])
    4. 평가하려는 출발지로부터 도착지까지 도달할 수 없으면 거리 무한대

- 정리
    - 굳이 거리를 계산할 필요 없을 것 같아 bool 타입으로 바꿔보았다
    - Floyd-Warshall 알고리즘
        - O(N^3)
        - 3차원 배열을 사용하지 않아도 되는 이유는 이해하기 조금 어렵다
            - [https://youtu.be/5uqOvsVmfJw?t=990](https://youtu.be/5uqOvsVmfJw?t=990)
        - all-to-all 최단 경로 알고리즘
            - one-to-one 또는 one-to-all : 벨만-포드, 다익스트라 알고리즘

    - 다익스트라 알고리즘(N^2)을 모든 노드에 적용한 것(N)과 시간 복잡도 면에서 유사