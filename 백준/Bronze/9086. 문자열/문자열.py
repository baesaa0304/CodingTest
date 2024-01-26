num = int(input())
str_list = []  # 문자들 입력받는 배열
str_answer = []  # 시작문자 끝문자 받는 배열

for _ in range(num):
    string = input()
    str_list.append(string)

for i in str_list:
    start = i[0]  # 시작 문자 추출
    end = i[-1]  # 끝 문자 추출
    str_answer.append(start + end)  # 시작과 끝 문자를 합쳐서 저장

print(*str_answer, sep='\n')  # 엔터로 구분하여 출력