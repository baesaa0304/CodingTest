M = int(input())
N = int(input())
list_sosu = []

for i in range(M, N+1): # 60부터 ~ 100까지
    no_sosu = 0
    if i > 1:
        for j in range(2, i):
            if i % j == 0:
                no_sosu += 1
                break
        if no_sosu == 0:
            list_sosu.append(i)                 
if len(list_sosu) > 0:
    print(sum(list_sosu))
    print(min(list_sosu))
else :
    print(-1)    