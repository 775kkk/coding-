

# Задача 1: Поиск всех подстрок в строке 
# Напишите функцию, которая принимает строку и возвращает 
# все возможные подстроки этой строки, не содержащие повторяющихся символов. 
# "aabc" -> "a" "b" "c" "ab" "ac" "bc" "abc" || 3 = 7
# "aabcD" -> "a" "b" "c" "D" "ab" "ac" "bc" "abc" "aD" "abD" "acD" "bcD" "bD" "cD" "abcD" || 4 = 14


def podstroki(stroka):
    # from itertools import permutations
    # stroka = stroka.replace(" ", "")
    # m=[]
    # for i in stroka:
    #     if i not in m:
    #         m.append(i)
    # # m = [i+j+k for i in list(permutations(no_povtor_spisok)) for j in list(permutations(no_povtor_spisok))[1:] for k in list(permutations(no_povtor_spisok))[2:]]
    # for i in range
    # return m
    stroka = stroka.replace(" ", "")

    m = []
    c = len(stroka)
    for i in range(c):
        for k in range(1,i-1):
            temp = [stroka[i:j+1] for j in range(i,c,k)]# пока проблема в сикпе надо скипать както чето -> abcD и еще надо acD
        # temp2 = [stroka[i]+stroka[-j] for j in range(1,i) if j<i]
        # temp2 = [stroka[i:-j] for j in range(1,i) if j<i] 
            for j in temp:
                if (len(set(j)) == len(j) and j not in m): # Проверка на уникальность символов
                    m.append(j)
        # for j in temp2:
            # if (len(set(j)) == len(j) and j not in m): # Проверка на уникальность символов
                # m.append(j)
    return m
print(podstroki("aabcDDh"))

# ///////////--------->


# Задача 2: Фильтрация чувствительных данных 
# Напишите функцию, которая принимает список строк и фильтрует из него все строки, 
# содержащие чувствительные данные (например, пароли или номера кредитных карт). Используйте регулярные выражения. 


# ///////////--------->


# Задача 3: Нахождение всех анаграмм 
# Напишите функцию, которая принимает две строки и проверяет, 
# являются ли они анаграммами (содержат ли одинаковые символы в разном порядке). 

# ///////////--------->


# Задача 4: Напишите функцию, которая печатает таблицу умножения для чисел от 1 до 10.
#  Используйте вложенные циклы для решения задачи.