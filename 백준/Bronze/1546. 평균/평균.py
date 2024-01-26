N = int(input())
score = list(map(int, input().split())) 
max_score = max(score)

new_avg = 0
for i in range(len(score)):
    new_avg += (score[i]/max_score*100)/N
print(new_avg)