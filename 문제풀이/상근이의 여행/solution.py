import sys

testcase=int(sys.stdin.readline().rstrip())

for t in range(testcase):
    
    list_tmp=list(map(int, sys.stdin.readline().rstrip().split(' ')))
    country=list_tmp[0]
    plane=list_tmp[1]

    list_route=[]
    for i in range(plane):

        list_tmp=sys.stdin.readline().rstrip().split(' ')
        
    print(country-1)