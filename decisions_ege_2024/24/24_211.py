# 211) Текстовый файл 24- 211. txt содержит строку из набора А, В, С, D, E, F, всего не более чем из 10° символов. Найдите максимальное количество подряд идущих четвёрок символов ABEC, BDAC, CAFB, CFBA, стоящих одна за другой и пересекающихся с соседними четвёрками одной буквой. Например, в строке BDEABECAFBDACBD такие пары составляют подстроку ABECAFBDAC = ABEC + CAFB + BDAC, итого 3 четвёрки.

f =open("decisions_ege_2024/dataFile/24-211.txt")
s=f.readline()
t=["ABEC","BDAC","CAFB","CFBA"]
l=lm=0
for i in range(1, len(s),3):#тут меняем ноль на 1 2 тАК КАК нас просят именно непрерывную цепочку а мы провверяем цепь с 4мя символами с шагом 3
    if s[i:i+4] in t:
        l+=1
        lm=max(l,lm)
    else : l=0
print(lm)#81 otv