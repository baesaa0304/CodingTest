N = int(input())
cnt = 0
for _ in range(N):
    word = list(input())
    for i in range(0, len(word)-1):
        if word[i] in word[i+1:]:
            if word[i] != word[i+1]:
                break
    else:
        cnt += 1
print(cnt)  