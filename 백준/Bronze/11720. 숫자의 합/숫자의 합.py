N = int(input()) # 입력받을 숫자의 길이
num_str = input()  # 숫자를 공백 없이 입력받음
sum = 0

for i in range(N):
    sum += int(num_str[i])  # 입력받은 문자열의 각 문자를 숫자로 변환하여 합산

print(sum)