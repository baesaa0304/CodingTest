N, M = map(int, input().split())  # 바구니의 갯수와 공을 담는 횟수 입력받기
bucket = [0] * N  # 바구니 초기화

for _ in range(M):
    I, J, K = map(int, input().split())  # 공의 위치와 넣을 공의 갯수 입력받기
    for j in range(I - 1, J):  # 공을 담는 범위 반복
        bucket[j] = K

for k in bucket:
    print(k)
