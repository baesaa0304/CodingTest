N = int(input())
cnt = N
for _ in range(N):
    word = list(input())
    for i in range(0, len(word)-1):
        if word[i] == word[i+1]:
            continue
        elif word[i] in word[i+1 : ]:
            cnt -=1
            break
print(cnt)