- 출처 : [https://www.acmicpc.net/problem/1613](https://www.acmicpc.net/problem/1613)

- 문제 : 백준 1613번 역사

- 틀린 풀이 : 위상 정렬, DFS
    1. 각 노드를 정렬 (위상 정렬)
    2. 연결되지 않은 노드 분리 (DFS)
    3. 연결된 노드일 경우 정렬된 리스트에서 인덱스 비교하여 1 또는 -1 출력
    4. 연결되지 않았을 경우 0 출력


- 틀린 이유 : 연결되어 있지만 관계를 모르는 경우가 존재  
    ![image](https://user-images.githubusercontent.com/28583563/104286494-75ce2980-54f8-11eb-9be9-0ace0933d311.png)