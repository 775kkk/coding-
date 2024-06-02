# 196) Текстовый файл 24-196. txt содержит строку из заглавных латинских букв X, Y и Z, всего не
# более чем из 106 символов. Определите максимальное количество идущих подряд пар символов
# ZX или ZY.

f=open("decisions_ege_2024/dataFile/24-196.txt")
s=f.readline();
s=s.replace("ZX", "*").replace("ZY", "*");
for i in range(len(s)+10):
    if "*"*i in s:
        print(i)#177 otw
