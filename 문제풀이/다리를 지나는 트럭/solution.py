def solution(bridge_length, weight, truck_weights):
    
    time=0
    bridge=[]
    while True:
        for i in range(len(bridge)):
            bridge[i][1]+=1

        while len(bridge)>0:
            if bridge[0][1]==bridge_length:
                bridge.pop(0)
            else:
                break
        
        curr_weight=0
        for t in bridge:
            curr_weight+=t[0]

        if len(truck_weights)!=0:
            if curr_weight+truck_weights[0]<=weight:
                bridge.append([
                    truck_weights.pop(0),
                    0
                ])

        time+=1
        if len(truck_weights)==0 and len(bridge)==0:
            break

    return time

print(solution(
    2, 10, [7,4,5,6]
))