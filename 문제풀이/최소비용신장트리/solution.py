'''
에지-비용 리스트가 주어졌을 때
모든 노드를 방문하는
최소 비용을 구하는 함수
'''
def solution(list_edge):

    # 모든 노드 초기화
    set_node = set()
    for edge in list_edge:
        set_node.add(edge[0])
        set_node.add(edge[1])        

    # cut 초기화
    # 초기에는 노드 개수
    list_cut = [{node} for node in set_node]
    deleted = [False for e in set_node]
    print(sorted(list_cut))

    # 가중치로 오름차순 정렬
    list_edge = sorted(list_edge, key=lambda x: x[2])

    result = 0
    # 가중치 순으로 순회
    for edge in list_edge:

        # 연결되어 있지 않은 경우 union
        idx1 = get_index(list_cut, deleted, edge[0])
        idx2 = get_index(list_cut, deleted, edge[1])
        if idx1 != idx2:
            # print(f'{edge[0]} - {edge[1]}')
            result += edge[2]
            list_cut[idx1] = list_cut[idx1] | list_cut[idx2]
            deleted[idx2] = True
    
    return result

# 특정 노드를 포함하는 cut의 인덱스를 리턴하는 함수
def get_index(list_cut, deleted, node):

    for i in range(len(list_cut)):
        if not deleted[i] and node in list_cut[i]:
            return i

    return -1

if __name__ == "__main__":
        
    data = [
        ['a','b',4],
        ['b','c',8],
        ['c','d',7],
        ['d','e',9],
        ['e','f',10],
        ['f','g',2],
        ['g','h',1],
        ['h','a',8],
        ['b','h',11],
        ['i','h',7],
        ['c','i',2],
        ['i','g',6],
        ['c','f',4],
        ['d','f',14],
    ]

    print(solution(data))