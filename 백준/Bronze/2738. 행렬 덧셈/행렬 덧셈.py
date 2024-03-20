N , M = map(int, input().split())
a = []
b = []
for _ in range(N):
    line = list(map(int, input().split()))
    a.append(line)
for _ in range(N):
    line = list(map(int, input().split()))
    b.append(line) 
# 행렬 덧셈
for i in range(N):
    for j in range(M):
        print(a[i][j]+b[i][j], end=" ")
    print()