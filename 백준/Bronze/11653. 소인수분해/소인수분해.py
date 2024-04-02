N = int(input())
soinsu = []
for i in range(2, N+1):
    while N % i == 0:
        soinsu.append(i)
        N //= i   
for k in soinsu:
    print(k)