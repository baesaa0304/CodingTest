grades = {"A+": 4.5, "A0": 4.0, "B+":3.5, "B0":3.0, "C+": 2.5, "C0" :2.0, "D+":1.5, "D0": 1.0, "F": 0} # 딕서녀리로 값을 저장해줌 키와 값!!
sum_exam_score = 0 # 학점의 총 합
score_grades_sum = 0 # 학점과 과목평점의 곱의 합
for i in range(20):
    exam_subject, exam_score, exam_grades= input().split()
    if exam_grades != "P":
        sum_exam_score += float(exam_score)
        score_grades_sum += float(exam_score) * grades[exam_grades]
print(score_grades_sum / sum_exam_score)        
