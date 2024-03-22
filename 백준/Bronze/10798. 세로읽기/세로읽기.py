height = []
for _ in range(5):
    width = list(input())
    height.append(width) 
    
for j in range(15):
    for i in range(5):
        if j < len(height[i]):
            print(height[i][j],end="") 