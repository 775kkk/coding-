# 272) (ЕГЭ-2023) Текстовый файл 24-264. txt состоит не более ем из 10° символов и содержит только заглавные буквы латинского алфавита и цифры. Определите максимальную длину подстроки, в которой ни одна буква не стоит рядом с буквой и ни одна цифра не стоит рядом с цифрой.

f=open("decisions_ege_2024/dataFile/24-264.txt")
s=f.readline()
a1="123456789"#0
a2="QWERTYUIOPSDFGHJKLZXCVBNM"#A
for i in a1:
    s=s.replace(i,"0")
for i in a2:
    s=s.replace(i,"A")

while "00" in s: s=s.replace("00","0 0")
while "AA" in  s: s=s.replace("AA","A A")
a=s.split()
print(max(map(len,a)))#18