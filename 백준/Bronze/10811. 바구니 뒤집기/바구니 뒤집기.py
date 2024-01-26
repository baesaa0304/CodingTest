N, M = map(int, input().split())
bucket = list(range(1,N+1))
for _ in range(M):
    i, j = map(int , input().split())
    temp = bucket[i-1:j]
    temp.reverse() # 역순으로 바꿔주는 함수
    bucket[i-1:j] = temp
for k in range(len(bucket)):
    print(bucket[k])