def getxy(str_num):
 
    phone=[
        ['1','2','3'],
        ['4','5','6'],
        ['7','8','9'],
        ['*','0','#'],
    ]

    for i in range(len(phone)):
        for j in range(len(phone[0])):
            if phone[i][j]==str_num:
                return [i,j]

    return [-1,-1]

def getsub(p1, p2):

    result=0

    if p1[0]<p2[0]:
        result+=p2[0]-p1[0]
    else:
        result+=p1[0]-p2[0]

    if p1[1]<p2[1]:
        result+=p2[1]-p1[1]
    else:
        result+=p1[1]-p2[1]

    return result

def solution(numbers, hand):
    answer = ''

    lxy=getxy('*')#[3,0]
    rxy=getxy('#')#[3,2]

    for n in numbers:
        
        nxy=getxy(str(n))#[0,0]

        if nxy[1]==0:
            answer+='L'
            lxy=nxy
            continue

        if nxy[1]==2:
            answer+='R'
            rxy=nxy
            continue

        len_ln=getsub(lxy, nxy)
        len_rn=getsub(rxy, nxy)

        if len_ln<len_rn:
            answer+='L'
            lxy=nxy
        elif len_ln>len_rn:
            answer+='R'
            rxy=nxy
        else:
            if hand=='right':
                answer+='R'
                rxy=nxy
            else:
                answer+='L'
                lxy=nxy
        
    return answer


if __name__ == "__main__":
    
    numbers=[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
    hand='right'
    
    print(solution(numbers, hand)=='LRLLLRLLRRL')