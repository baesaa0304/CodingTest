H , M = map(int, input().split())  # 시간 분

if M < 45:
    H -= 1
    M = (M + 60) - 45
    if H < 0:
        H = 23
    print(H, M)
else:
    print(H, (M - 45))


    