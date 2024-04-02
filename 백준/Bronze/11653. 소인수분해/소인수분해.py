N = int(input())
soinsu = []
divisor = 2

while N > 1:
    while N % divisor == 0:
        soinsu.append(divisor)
        N //= divisor
    divisor += 1   
for k in soinsu:
    print(k)
