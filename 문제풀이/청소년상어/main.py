# def print_space(n, num):

#     for i in range(num-1):
#         print(' ', end='')

# def print_star(n, num):
    
#     for i in range(2*(n-num)+1):
#         print('*', end='')

# def print_row(n, num):
    
#     print_space(n, num)
#     print_star(n, num)
#     # print_space(n, num)

# # n=int(input())s
# n=5

# for i in range(1, n+1):
#     print_row(n, i)
#     print('')

text=input()
list_temp=text.split()
h=int(list_temp[0])
m=int(list_temp[1])

m-=45
if m<0:
    m+=60
    h-=1
    if h<0:
        h+=24
print('%s %s' % (h, m))