a = int(input())

for _ in range(a):
  b, c = input().split()
  for j in c:
    print(j*int(b), end="")
  print()  
