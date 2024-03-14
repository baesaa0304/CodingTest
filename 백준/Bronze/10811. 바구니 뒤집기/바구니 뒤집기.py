N , M = map(int, input().split()) 
bucket = list(range(1, N+1))
for _ in range(M):
      i, j = map(int, input().split())
      temp = bucket[i-1 : j]
      temp.reverse()
      bucket[i-1 : j] = temp
for k in (bucket):
      print(k)          