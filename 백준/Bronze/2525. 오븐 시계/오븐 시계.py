H , M = map(int, input().split()) #시간, 분
C = int(input()) #  요리시간
M += C
if M >= 60:
    H += M // 60
    M = M % 60

if H >= 24:
    H %= 24
   
    print(H, M)
else:
    print(H, M)

    
