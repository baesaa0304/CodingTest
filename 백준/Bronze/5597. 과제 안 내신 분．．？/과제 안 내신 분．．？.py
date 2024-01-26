arr = [False] * 31  # True와 False의 결과값을 보여줌
for _ in range(28):
    k = int(input())  # 정수 하나씩 입력 (k는 인덱스 번호)
    arr[k] = True  # 해당 인덱스를 True로 변환

for i in range(1, len(arr)):
    if not arr[i]:
        print(i)  # 인덱스 번호를 출력

