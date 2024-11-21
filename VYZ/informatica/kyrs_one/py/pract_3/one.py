

# Задача 1: Поиск всех подстрок в строке 
# Напишите функцию, которая принимает строку и возвращает 
# все возможные подстроки этой строки, не содержащие повторяющихся символов. 
# "aabc" -> "a" "b" "c" "ab" "ac" "bc" "abc" || 3 = 7
# "aabcD" -> "a" "b" "c" "D" "ab" "ac" "bc" "abc" "aD" "abD" "acD" "bcD" "bD" "cD" "abcD" || 4 = 14


def podstroki(stroka):
    stroka = stroka.replace(" ", "*") #тк мы ищем подстроки а не подслова пробелы надо както оставить

    m = []
    c = len(stroka)
    for i in range(c):
        temp = [(stroka[i:j+1]).replace("*", " ") for j in range(i,c)]
        temp2= [(m[j].replace(" ","*")+temp[k]).replace("*", " ") for k in range(len(temp)) for j in range(len(m))] # А КТО МНЕ ПОМЕШАЕТ СДЕЛАТЬ КАШУ??? ХАХАХАХАХАХ
        # просто перемешиваем как можем все наши значения
        # вмонтированы реплейсы так прям чтоб наверняка
        for j in temp: # отбраковка (работает больше всех)
            if (len(set(j)) == len(j) and j not in m):
                m.append(j)
        for j in temp2: # отбраковка (работает больше всех)
            if (len(set(j)) == len(j) and j not in m):
                m.append(j)
    # сглаживаем последствия учета пробелов через звездочку
    m.remove(" ")
    #удаляем пробелы перед и вконце слова(строки)
    for i in range(len(m)):
        if (m[i][0]==" "):
            m[i]=m[i][1:]
        if (m[i][-1]==" "):
            m[i]=m[i][:-1]
    #теперь убрав ранее уникальные "ah_" получили дубликаты "ah","ah" без пробелов со всех сторон, не дела...
    m=list(set(m))
    return m
    # однако список совсем не отсортированный прям вот вообще никак не отсортированный прям фу бе, но там все есть

# print("abcDh" in podstroki("aabcDh")) 
# print(podstroki("aab cDh"))


# ///////////--------->


# Задача 2: Фильтрация чувствительных данных 
# Напишите функцию, которая принимает список строк и фильтрует из него все строки, 
# содержащие чувствительные данные (например, пароли или номера кредитных карт). Используйте регулярные выражения. 

def filtr(mass):
    dw =["password","Password","пароль","Пароль","Телефон","телефон","номер телефона","Номер телефона","номера телефонов","Номера телефонов","phone number","Phone number","phone numbers","Phone numbers","card number","Card number","card numbers","Card numbers","security numbers","security number","Security numbers","Security number"
        ]
    for i in mass:
        if any((g in i) for g in dw):
            mass.remove(i)
    return mass

# print(filtr(["avvevebebe password","sdsdfwf bebebebe","телефон"]))

# ///////////--------->


# Задача 3: Нахождение всех анаграмм 
# Напишите функцию, которая принимает две строки и проверяет, 
# являются ли они анаграммами (содержат ли одинаковые символы в разном порядке). 

def annogram(str1 , str2):
    if set(str1)==set(str2):    
        return True
# print(annogram("1aav","v1aa"))

# ///////////--------->


# Задача 4: Напишите функцию, которая печатает таблицу умножения для чисел от 1 до 10.
#  Используйте вложенные циклы для решения задачи.

def tabl_ymnosh():
    for i in range(1,10):
        for j in range(1,11):
            print(str(i)+"*"+str(j)+"="+ str(j*i))
        print("-----")
tabl_ymnosh()