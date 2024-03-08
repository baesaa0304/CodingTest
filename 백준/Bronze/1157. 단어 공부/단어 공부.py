word = input().upper()  # Zza -> zza
word_list = list(set(word))  # [z,a]
a = []
for i in word_list:
  a.append(word.count(i))  # [2, 1]
if a.count(max(a)) > 1:
  print("?")
else:
  print(word_list[a.index(max(a))])