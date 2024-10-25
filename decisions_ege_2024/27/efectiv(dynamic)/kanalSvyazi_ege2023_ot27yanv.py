# 165) (ЕГЭ-2023) По каналу связи передаётся последовательность целых чисел - показания прибора. В
# течение N минут (N - натуральное число) прибор ежеминутно регистрирует значение силы тока (в
# условных единицах) в электрической сети и передаёт его на сервер. Определите три таких
# переданных числа, чтобы между моментами передачи любых двух из них прошло не менее К минут,
# а сумма этих чисел была минимально возможной. Залишите в ответе найденную сумму.

# Входные данные: Даны два входных файла: файл A (27-165a. txt) и файл В (27-165b. txt),
# каждый из которых в первой строке содержит натуральное число N (1 < N < 10 000 000)
# - количество переданных показаний, и натуральное число К (К < N)
# - минимальное количество минут, которое должно пройти между моментами передачами любых двух
# из трёх показаний. В каждой из следующих N строк находится одно натуральное число,
# не превышающее 10 000 000, которое обозначает значение силы тока в соответствующую минуту.
# Пример входного файла:
# 6 2 (N K)
# 15 
# 14
# 20
# 23
# 21
# 10
# При таких исходных искомая величина равна 45 - это сумма значений, зафиксированных первой, третьей и шестой минутах измерений. Ответ: 45.
# В ответе укажите два числа: сначала искомое значение для файла А, затем для файла В.
f=open("decisions_ege_2024/dataFile/27-165b__31xnk (1).txt")
n,k=map(int,f.readline().split())#170656 28442
a=[int(x) for x in f]
m=ms=9999999999999999999999999999# ❗️❗️тк сумма минимально возможная
ms2=99999999999999999#тертья мин сумма(мин сумма трех эл)
for i in range(n-k-k):#-2k тк у нас тройки❗️❗️
    if a[i]<m:# именно м позволяет сделать не менее k минут
        m=a[i]# мы ищем минимальное число
    if m+a[i+k]<ms:# а заодно пока ищем сравниваем не а[i]+a[i+k]
        ms=m+a[i+k]# а именно m+a[i+k], тк между м и a[i+k] гарантированно прошло k минут
# print(ms)# 15630 # ❗️❗️ЭТО если бы были ДВОЙКИ❗️❗️
    if ms+a[i+k+k]<ms2:
        ms2=ms+a[i+k+k]
print(ms2)#23445 finely
#выше был дилетантский код, вот код настоящих архитекторов еге
m=ms=9999999999999999999999999999
ms2=99999999999999999
for i in range(n-k-k):
    m=min(m,a[i])
    ms=min(ms,m+a[i+k])
    ms2=min(ms2,ms+a[i+k+k])
print(ms2)#23445 XD)))
