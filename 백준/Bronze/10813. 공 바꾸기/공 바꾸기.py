N, M = map(int, input().split())
#bucket = [0] * N
bucket = list(range(1, N + 1))

for _ in range(M):
      i, j = map(int, input().split())
      bucket[i - 1], bucket[j - 1] = bucket[j - 1], bucket[i - 1]

for k in range(len(bucket)):
      print(bucket[k])

