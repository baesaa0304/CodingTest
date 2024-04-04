garo = []
sero = []
for _ in range(3):
    sd = []
    N , M = list(map(int, input().split()))
    garo.append(N)
    sero.append(M)
garoes = 0
seroes = 0 
for i in garo:
    if garo.count(i) == 1:
        garoes = i
for i in sero:
    if sero.count(i) == 1:
        seroes = i     
print(garoes , seroes)