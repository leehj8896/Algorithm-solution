def solution(n):
    
    result=[]

    num2='0'+get2(n)
    list_num2=list(num2)
    end=-1
    for i in range(0, len(num2)-1):
        if num2[i]=='0' and num2[i+1]=='1':
            list_num2[i]='1'
            list_num2[i+1]='0'
            end=i+2
            break

    list_temp=list_num2[end:]
    count1=list_temp.count('1')
    count0=list_temp.count('0')    

    list_sum=list_num2[:end]+['0']*count0+['1']*count1
    temp=''.join(list_sum)
    print(temp)
    return get10(temp)

def get10(temp):
    b=1
    result=0
    for i in range(len(temp)-1, -1, -1):
        result+=int(temp[i])*b
        b*=2
    return result

def get2(n):

    result=''
    while True:
        result=str(n%2)+result
        n=n//2
        if n==0:
            break
    return result


print(solution(78))