A, B ,V = map(int, input().split())
count = 0
if (V - B) % (A - B) == 0:
    count+= (V - B) // (A - B)     
else :
    count+= (V - B) // (A - B) + 1
print(count)    