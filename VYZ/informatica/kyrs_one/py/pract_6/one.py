# =====================
# задание 1
# Максимальная длина монотонного фрагмента 

spisok=[1,2,3,4,5,5,6,7,11]

def maxMonotonFragment(spisok):
    perv=0;
    i=0
    result=[0]*len(spisok);
    # for i in range(len(spisok)):
    while True:
        if spisok[i]>perv:
            result[i]+=1;
        perv=spisok[i]
        i+=1;
        if i==len(spisok)-1 : break
    result1=0;
    i=0
    maxResult=-32000
    # for i in result:
    while True:
        if result[i]!=0:
            result1+=result[i]
            maxResult=max(maxResult,result1)
        else: result1=0
        i+=1;
        if i==len(spisok): break
    return maxResult
# print(maxMonotonFragment(spisok))
# =====================
# Задача 2 
# Наименьшее расстояние между локальными максимумами 
spisok=[1,2,3,4,3,5,6,99,1,1,1,1,66,2]

def minRangeLockalMax(spisok):
    resSps=[0]*len(spisok)
    perv1=0
    perv2=0
    i=0
    while True:
        if (perv1<perv2>spisok[i]) and (i>=2):
            resSps[i-1]=1
        perv1=perv2
        perv2=spisok[i]
        i+=1;
        if i==len(spisok) : break
    i=0
    minRange=32000
    mainRange=32000
    flagNotStart=False;
    while True:
        if (resSps[i]==0) and (flagNotStart):
            mainRange+=1
        if resSps[i]==1:
            flagNotStart=True;
            minRange=min(minRange,mainRange);
            mainRange=0
        i+=1;
        if i==len(spisok)-1 : break
    return minRange
# print(minRangeLockalMax(spisok))
# =====================
# Задача 3 Стандартное отклонение
posledovatelnost=[1,2,3]
def StandartOtklon(posledovatelnost):
    srArifm=sum(i for i in posledovatelnost)/len(posledovatelnost)
    otkl= (sum((x-srArifm)**2 for x in posledovatelnost)/(len(posledovatelnost)-1))**0.5
    return otkl
# print(StandartOtklon(posledovatelnost))
# =====================
# 4 переворот числа
chislo = 56734
def revers(chislo):
    result = 0
    while chislo>0:
        result=(result*10)+(chislo%10)
        chislo=chislo//10
    return result
# print(revers(chislo))

# =====================
# 5 колво чисел делящихся на 7 без остатка
spisok= [1,2,3,4,14,15,7,8,9,21]#3
def delSeven(spisok):
    result=0
    for i in spisok:
        if i%7==0:
            result+=1;
    return result;
# print(delSeven(spisok))

# =====================
# Задача 6 Теорема Лагранжа (рекурсия)
def Lagrandgj(chislo,n):
    result=[]
    if int(chislo**0.5)==chislo**0.5:
        result.append(int(chislo*0.5))
        return result
    # го крч квадрат первый максимальный найдем и от него плясать типа рекурсией типа chislo-найденный квадрат
print(48**0.5==int(48**0.5))