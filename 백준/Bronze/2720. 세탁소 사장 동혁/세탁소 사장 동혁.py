T = int(input())
dict = [25, 10,  5 , 1]
for i in range(T):
    C = int(input())
    cost = [] 
    for j in dict:
        cost.append(C // j)
        C %= j
    print(*cost)    
print() 