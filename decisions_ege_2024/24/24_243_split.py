# 243) Текстовый файл 24-241 . txt состоит не более чем из 10^6 символов и содержит только
# латинские буквы А, В, C, D, E, F, O. Определите длину самой длинной цепочки символов, которая начинается и заканчивается буквой О, а между двумя последовательными буквами О содержит не
# более двух букв F и произвольное количество других букв.

f=open("decisions_ege_2024/dataFile/24-241__3ba61.txt").readline()
a=f.split("O")

print(f[0],f[-2]) #f[-1] это /n
#тут мы выяснили что боковые цепочки у сплита нельза брать тк у них нет конца/начала O

mx=0
for i in range(1,len(a)-1):# 1 -1 - не взяли боковые
    if a[i].count("F")<=2:
        mx=max(len(a[i]),mx)
print(mx+2)#+2 за первый и последний символ(это O)
#48