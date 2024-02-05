S = input()
alphabet = list(range(97, 123)) # 아스키코드값
for i in alphabet:
  print(S.find(chr(i)), end= ' ')