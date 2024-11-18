# Задание 1: Словарь частоты слов 
 
# Напишите программу, которая принимает строку текста от пользователя и создает словарь,
# отображающий количество вхождений каждого слова. Игнорируйте регистр и знаки препинания.

def slovar(stroka):
    '''
    stroka = stroka.split();

    #  { ver 1
    # m = [list((i,stroka.count(i)))for i in stroka];#(охота продолжить  if i not in m) но и такая проверка не будет правильной
    # for i in range (len(m)):
    #     print("The word `"+ m[i][0] + "` has " + str(m[i][1]) + " meanings")
    # return m } НО ТУТ СЛОВА ВЫВОДЯТСЯ ПОВОТЯЮЩИЕСЯ 

    #  { ver 2
    # m=[[]]
    # se=[]
    # for i in stroka:
    #     if i not in se:
    #         se.append(i)
    #         m.append(list((i,stroka.count(i))))
    # m.pop(0)
    # for i in range (len(m)):
    #     print("The word `"+ m[i][0] + "` has " + str(m[i][1]) + " meanings")
    # return m  }
    '''
    # VER 3 (mutant)
    from collections import Counter

    m = [[slovo, povtorenii] for slovo, povtorenii in Counter(stroka.split()).items()]# в шоке

    for i in range (len(m)):
        print("The word `"+ m[i][0] + "` has " + str(m[i][1]) + " meanings")
    # return m

# slovar("AAAA vbek AAAA vdeev")
# ///////////--------->


# Задание 2: Фибоначчи 
 
# Напишите функцию, которая генерирует n чисел Фибоначчи, 
# где n задается пользователем. Верните результат в виде списка.
#  0 1 1 2 3 5 8 13 21 

def fibList(n):
    fibList = list((0,1))
    for i in range(n):
        fibList.append(fibList[-2]+fibList[-1])
    return(fibList)
# print(fibList(7))
# ///////////--------->


# Задание 3: Сортировка по убыванию 
 
# Создайте программу, которая принимает список чисел от пользователя и сортирует его по убыванию, 
# не используя встроенные функции сортировки. Реализуйте собственный алгоритм сортировки. 

def sort1(arrayMass):
    retArr=list()
    while arrayMass:
        retArr.append(max(arrayMass))
        arrayMass.remove(max(arrayMass))
    return retArr
print(sort1([3,3,9,2,1,0,7]))

# ///////////--------->


# Задание 4: Конвертер температур 
 
# Напишите функцию, которая принимает температуру в градусах Цельсия и конвертирует её в градусы Фаренгейта и Кельвина.
# Функция должна возвращать кортеж с результатами.

def convertTempC(temp):
    return [["Kelv", temp-273],["Far", temp*1,8]]

# print(convertTempC())

# ///////////--------->


# Задание 5: Уникальные элементы списка 
 
# Создайте программу, которая принимает список чисел от пользователя и возвращает новый список, 
# содержащий только уникальные элементы (без дубликатов). Используйте множества для этой задачи.

def ynikalnost(arr):
    return list(set(arr))