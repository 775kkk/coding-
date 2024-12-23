# 379) (ЕГЭ-2023) В файле 17-379.txt содержится последовательность 
# натуральных чисел. Элементы последовательности могут принимать 
# целые значения от 1 до 100 000 включительно. Определите количество 
# троек последовательности, в которых только одно из чисел является 
# четырёхзначным, а сумма элементов тройки не меньше максимального элемента 
# последовательности, оканчивающегося на 15. В ответе запишите количество 
# найденных троек, затем максимальную из сумм элементов таких троек. 
# В данной задаче под тройкой подразумевается три идущих подряд
# элемента последовательности.

f = open("decisions_ege_2024/dataFile/17-379__3aktr.txt")
a = [int(x) for x in f]
m15=max(x for x in a if str(x)[-2:]=="15")#x%100==15
# print(m15)#96615
mx=c=0

for i in range(len(a)-2):
    t=[x for x in a[i:i+3] if len(str(x))==4 ]
    if (len(t)==1) and (sum(a[i:i+3])>=m15):
        c+=1
        mx=max(mx,sum(a[i:i+3]))
print(c,mx)#299 196183

# 380) (ЕГЭ-2023) В файле 17-380.txt содержится последовательность 
# целых чисел, не превышающих по модулю 100 000. 
# Определите количество троек элементов последовательности, в которых не
# более двух из трёх элементов являются четырёхзначными числами, 
# а сумма элементов тройки не больше максимального элемента 
# последовательности, оканчивающегося на 25. В ответе запишите 
# количество найденных троек чисел, затем максимальную 
# из сумм элементов таких троек. В данной задаче под тройкой 
# подразумевается три идущих подряд элемента последовательности.
f=open("decisions_ege_2024/dataFile/17-380__3aktq.txt")
a=[int(x) for x in f]
m25=max(x for x in a if abs(x)%100==25)
# print(m25)#84725
с=0
mx=-999999999999999999999999999999999
for i in range(len(a)-2):
    t=[x for x in a[i:i+3] if len(str(abs(x)))==4]
    if (len(t)<=2) and (sum(a[i:i+3])<m25):
        c+=1
        mx=max(mx,sum(a[i:i+3]))
print(c,mx)#6614 84523