- 출처 : [https://www.acmicpc.net/problem/16236](https://www.acmicpc.net/problem/1987)

- 알고리즘 : DFS, 재귀

- DFS 구현 방법
    - 현재 좌표에서 경로 길이 update
        - 26일 경우 종료
    - 상, 하, 좌, 우로 재귀
        - visited = True, 재귀, visited = False

- visited 구현 방법
    - A-Z를 ord 함수로 0-25로 바꾼 뒤 boolean 저장
    - set 안됨 (why??)

- 소감
    - 구글링 소스 코드 참고
    - pypy3 통과
    - 시간 제한이 굉장히 빡센 것 같다
    - 상, 하, 좌, 우로 반복할 때도 함수로 if문 쓰니 통과했다가 다시 하니까 시간 초과 됨
    - (1,-1,0,0 ) (0,0,1,-1) 하니까 됨
    - visited를 set으로 만들어서 add, remove 했을 때 왜 안되는 건지 모르겠다 복잡도 O(1) 인데..
    - 전역 변수를 더 많이 활용해야겠다