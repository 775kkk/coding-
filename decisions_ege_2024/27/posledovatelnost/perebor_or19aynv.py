
# 75) (демо-2022) Дана последовательность из N натуральных чисел.
#  Рассматриваются все её непрерывные подпоследовательности,
# такие что сумма элементов каждой из них кратна k = 43.
# Найдите среди них подпоследовательность с максимальной суммой,
# определите её длину. Если таких подпоследовательностей найдено
# несколько, в ответе укажите количество элементов самой короткой
# из них.
# Входные данные: Даны два входных файла: файл A (27-75a.txt) и файл В (27-75b.txt), каждый из которых содержит в первой строке количество чисел N (2 s N s 108). Каждая из следующих N строк содержит натуральное число, не превышающее 10000.
# Пример входного файла:
# 21
# 13
# 19
# 17
# 26
# 95
# В этом наборе можно выбрать последовательности 21+13+9 (сумма 43) и 17+26 (сумма 43). Самая короткая из них, 17 + 26, имеет длину 2. Ответ: 2.
# В ответе укажите два числа: сначала значение искомой суммы для файла А, затем для файла В.
# это неэффектив реешение
f=open("decisions_ege_2024/dataFile/27-75a__2zeg5 (1).txt")
n=int(f.readline())
a=[int(i) for i in f]
mx=0
for i in range(len(a)):
    s=0
    for j in range(i,len(a)):
        s+=a[j]
        if s%43==0:
            mx=max(mx,s)
        if s==1806387:
            print(j-i+1)# длинна, но тут длинна это по сути колво точек поэтому +1
print(mx)#1806387 макс сумма