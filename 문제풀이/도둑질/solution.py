def solution(list_money):

    list_selected=[False for i in range(len(list_money))]
    
    list_temp=[]
    for i in range(len(list_money)):
        list_temp.append(
            get_max(list_money,list_selected,i)
        )

    return max(list_temp)

def get_max(list_money,list_selected,idx):

    if idx-1==-1:
        list_selected[len(list_selected)-1]=True
    else:
        list_selected[idx-1]=True
    list_selected[idx]=True
    if idx+1==len(list_money):
        list_selected[0]=True
    else:
        list_selected[idx+1]=True

    list_temp=[]
    for i in range(len(list_money)):

        if not list_selected[i]:
            list_temp.append(get_max(list_money,list_selected,i))

    
    if idx-1==-1:
        list_selected[len(list_selected)-1]=False
    else:
        list_selected[idx-1]=False
    list_selected[idx]=False
    if idx+1==len(list_money):
        list_selected[0]=False
    else:
        list_selected[idx+1]=False

    return list_money[idx]+max(list_temp)
