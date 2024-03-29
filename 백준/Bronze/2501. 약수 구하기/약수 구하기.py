N , K = map(int, input().split())
min_measure = []
for i in range(1, N + 1):
    if N % i == 0:
        min_measure.append(i)
if len(min_measure) < K:
    print(0)            
else:
    print(min_measure[K-1])