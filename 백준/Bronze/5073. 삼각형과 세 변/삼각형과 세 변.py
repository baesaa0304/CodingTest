while True:
    a, b ,c = map(int, input().split())
    if a == 0 and b == 0 and c == 0: 
        break
    if max(a, b, c) < ((a+b+c) - max(a, b, c)):
        if a == b == c:
            print('Equilateral')
        elif a == b or a == c or b == c:
            print('Isosceles')
        else:
            print('Scalene')
    else : 
        print('Invalid')  

