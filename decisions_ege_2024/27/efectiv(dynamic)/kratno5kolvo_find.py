#необходимо определить колво пар элементов в которых их произведение кратно 5
f=open("decisions_ege_2024/dataFile/27-12b__31m62 (1).txt")
n=int(f.readline())#колво чисел в файле
a=[int(i) for i in f]
#структура :
#кратные на 5 на все числа
#не кратные на 5 на кратные 5
c5=r=0
for i in range(len(a)-1):
    if a[i]%5==0:
        c5+=1
    if a[i+1]%5!=0:#если текущее не кратно 5 и следующее не кратно 5
        r+=c5#то текущее это пара для всех кратных 5
    else:#кароче если следующее кратно 5, то для него все предыдущие это множители
        r+=i+1# +1 тут это учет текущего числа
# это очень не стандартная структура для мышления... ОЧЕНЬ ОЧЕНЬ
# я просто происходящее минут 10 моделировал в башке
print(r)
#   0      1        2       3     4       5       6       7
#   x      y        z       w     v       p       t       h  #тк len(a)-1
#   %5    !%5      !%5      %5    %5     !%5      %5      %5
#  c5++   r+=c5  r+=i+1   c5++   c5++   r+=i+1   c5++     -  #чета блять мне кажется дыра тут
#  r+=c5                    -    r+=c5             -         # башка моя интуитивно не понимает этот код
# r по идее:
#    7                     13     18              22      25 # даже счас когда около наглядно все представлено
#r по коду:
#c5=1;r=1 r=2      r=5    c5=2  c5=3;r=8  r=14   c=4  итог р=14, чтобл
# крч бракую это нах