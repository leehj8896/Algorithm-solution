def init():

    w, h = map(int, input('').split(' '))

    bottom_list, top_list = [], []

    import sys
    for i in range(w):
        n = int(sys.stdin.readline().rstrip())
        if i % 2 == 0:
            bottom_list.append(n)
        else:
            top_list.append(n)
    
    return w, h, top_list, bottom_list


def get_current_section(idx, position):

    top_length = top_list[idx]
    bottom_length = bottom_list[idx]

    # 딱 맞으면
    if h == top_length + bottom_length:

        return (0, h)
    
    # 겹치는 부분 있으면
    if h < top_length + bottom_length:

        # bottom 이면
        if position == 1:
            start = 0
            end = bottom_length - (top_length + bottom_length - h)
        # top 이면
        if position == -1:
            start = bottom_length
            end = h

        return (start, end)

    # 떨어져 있으면
    if h > top_length + bottom_length:

        start = bottom_length
        end = h - top_length
        return (start, end)


def is_bigger_than(section1, section2):

    return section1[1] - section1[0] > section2[1] - section2[0]

def get_section(start, end, step):

    start = 0
    end = w
    step = 1

    section = get_current_section(start, step)
    input(section)

    for i in range(start+1, end, step):

        temp = get_current_section(i, step)
        if is_bigger_than(section, temp):


            return section
        else:
            section = temp
    
    return section


w, h, top_list, bottom_list = init()



bottom_list.sort()
top_list.sort(reverse=True)

for i in range(len(bottom_list)):
    print(bottom_list[i], top_list[i])

bottom_step = 1
top_step = -1

bottom_section = get_section(0, w, bottom_step)
top_section = get_section(w-1, -1, top_step)

print(bottom_section)
print(top_section)

# union = get_union()

# print(get_length(union))