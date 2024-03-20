grid = []
for _ in range(9):
    line = list(map(int, input().split()))
    grid.append(line)
max_value = 0
max_row , max_col  = 0 , 0
for row in range (len(grid)):
    for col in range (len(grid[row])):
        if grid[row][col] >= max_value:
            max_value = grid[row][col]
            max_row , max_col =  row + 1, col+ 1
print(max_value)
print(max_row , max_col)