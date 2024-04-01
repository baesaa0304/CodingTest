while True:
    N = int(input())
    if N < 0:
        break
    Yaksu = []
    for i in range(1, N):
        if N % i == 0:
            Yaksu.append(i)
    sum_of_yaksu = sum(Yaksu)        
    if sum_of_yaksu != N:      
        print(N ,'is NOT perfect.')   
    else:
        print(str(N) + ' = ' + ' + '.join(str(j) for j in Yaksu))
        
