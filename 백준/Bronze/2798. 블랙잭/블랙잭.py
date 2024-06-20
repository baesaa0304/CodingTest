from itertools import combinations

def blackjack(n, m, cards):
    max_sum = 0

    # 3장의 카드를 고르는 모든 조합을 검사합니다.
    for comb in combinations(cards, 3):
        current_sum = sum(comb)
        # 현재 합이 m 보다 작거나 같고, max_sum 보다 크다면 max_sum을 갱신합니다.
        if current_sum <= m and current_sum > max_sum:
            max_sum = current_sum

    return max_sum

# 입력 받기
n, m = map(int, input().split())
cards = list(map(int, input().split()))

# 함수 호출
result = blackjack(n, m, cards)
print(result)
