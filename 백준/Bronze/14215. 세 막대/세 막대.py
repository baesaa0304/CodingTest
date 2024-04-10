a, b ,c = map(int, input().split())
max_number = max(a,b,c)
another_number = (a+b+c) - max(a,b,c)

if max_number < another_number:
    print(a+b+c)
elif max_number >= another_number:
    number_c = max_number - (max_number - another_number  + 1)
    print(another_number + number_c)