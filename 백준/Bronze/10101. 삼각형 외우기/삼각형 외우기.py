a = int(input())
b = int(input())
c = int(input())
if a == b == c:
    print('Equilateral')
elif a + b + c == 180:
    if a == b or a == c or b == c:
       print('Isosceles')
    elif a != b!= c:
        print('Scalene')    
elif a + b + c != 180:
    print('Error')        