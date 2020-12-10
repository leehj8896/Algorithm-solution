def solution(num):

    count=0

    while True:
        
        if num==1:
            return count
        else:
            if count>500:
                return -1

        num=colla(num)
        count+=1


def colla(num):

    if num%2==0:
        return num/2
    else:
        return num*3+1