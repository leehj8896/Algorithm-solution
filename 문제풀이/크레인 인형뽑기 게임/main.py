def solution(board, moves):
    answer = 0

    new_board=[[] for i in range(len(board))]
    for i in range(len(board)):
        for j in range(len(board)):
            
            if board[i][j]==0:
                pass
            else:
                new_board[j].insert(0, board[i][j])

    basket=[]

    for i in range(len(moves)):
        
        if len(new_board[moves[i]-1])==0:
            continue
        curr=new_board[moves[i]-1].pop()

        if len(basket)==0:
            basket.append(curr)
        else:
            after=curr
            before=basket[len(basket)-1]
            
            if before==after:
                basket.pop()
                answer+=2
            else:
                basket.append(after)
    
    return answer

if __name__ == "__main__":

    board=[
        [0,0,0,0,0],
        [0,0,1,0,3],
        [0,2,5,0,1],
        [4,2,4,4,2],
        [3,5,1,3,1]
    ]

    moves=[1,5,3,5,1,2,1,4]

    print(solution(board, moves))