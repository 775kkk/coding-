def comandaZZZ(x,c):
    b = x+c
    return b
def srArifm2(x,Z):
    b=x+Z
    return b/2
# Функцию считать ср арифм 5 числами
def srArifm5(a,b,c,d,f):
    return (a+b+c+d+f)/5
# print(srArifm5(10,10,10,10,10))

# Исользуя три функции написанные выше,, написать функцию которая :
    # 1. Посчитает среднее арифметическое между(2) среднем арифметическим 10ти чисел (2)
    # ЧТО НАМ НАДО?
    # 1) ФУНКЦИЯ которая вычисляет ср арифм между двумя числами
    # 2) ФУНКЦИЯ которая вычисляет ср арифм между 10ю числами
def resultDZ(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10):
    Aone = srArifm5(a1,a2,a3,a4,a5)
    Atwo = srArifm5(a6,a7,a8,a9,a10)
    Aresult = srArifm2(Aone,Atwo)
    Bone = srArifm5(b1,b2,b3,b4,b5)
    Btwo = srArifm5(b6,b7,b8,b9,b10)
    Bresult = srArifm2(Bone,Btwo)
    ret = srArifm2(Aresult,Bresult)
    return ret

print(resultDZ(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20))
