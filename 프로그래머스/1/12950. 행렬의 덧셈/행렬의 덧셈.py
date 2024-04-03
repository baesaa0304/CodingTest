def solution(arr1, arr2):
    answer = []
    for i in range (len(arr1)):
        answer_1 = []
        for j in range (len(arr1[i])):
            answer_1.append(arr1[i][j] + arr2[i][j])
        answer.append(answer_1)  
    return answer