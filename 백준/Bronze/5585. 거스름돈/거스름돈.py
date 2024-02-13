S = int(input())
cost = 1000 - S
moneys = [500, 100, 50, 10, 5, 1] # 거스름돈들
result = 0

for i in moneys:
  if cost == 0:
    break
  result += cost // i
  cost %= i
print(result)  