# (Досрочный ЕГЭ-2023) Входной файл содержит заявки пассажиров, желающих сдать свой багаж в камеру хранения. 
# В заявке указаны время сдачи багажа и время освобождения ячейки 
# (в минутах от начала суток). Багаж одного пассажира размещается в 
# одной свободной ячейке с минимальным номером. Ячейки пронумерованы 
# начиная с единицы. Размещение багажа в ячейке или её освобождение 
# происходит в течение 1 мин. Багаж можно поместить в только что 
# освобождённую ячейку начиная со следующей минуты. Если в момент 
# сдачи багажа свободных ячеек нет, то пассажир уходит.

# Определите, сколько пассажиров сможет сдать свой багаж в течение 24 часов и 
# какой номер будет иметь ячейка, которую займут последней. 
# Если таких ячеек несколько, укажите минимальный номер ячейки.

# Входные данные представлены в файле 26-111.txt следующим образом. 
# В первой строке входного файла находится натуральное число K, не 
# превышающее 1000 - количество ячеек в камере хранения. Во второй строке - 
# натуральное число N (N ≤ 1000), обозначающее количество пассажиров. 
# Каждая из следующих N строк содержит два натуральных числа, 
# каждое из которых не превышает 1440: указанное в заявке время размещения 
# багажа в ячейке и время освобождения ячейки (в минутах от начала суток).

# Запишите в ответе два числа: количество пассажиров, 
# которые смогут воспользоваться камерой хранения, и номер последней занятой ячейки.

# Разберемся с входными данными

#помни что у нас второе число менее 1440

#суммируя нам надо определить число пассажиров 
# которые смогли воспользоваться камерой хранения
# и номер последней занятой ячейки 

# 210 колво ячеек всего
# 987 колво людей которые хотят сдать суммарно (колво оставленных заявок на сдачу по сути)
# 101 981 : 101 - время (от 0) когда сдали багаж,, 981 - время (от 0) когда забрали багаж
# 679 1159
# 705 797
# 826 1367
# 162 654
# 392 1181
# 367 1277
# 662 906

f=open("decisions_ege_2024/dataFile/26-111__2s4jp.txt")
k=int(f.readline())#колво ячеек всего
n=int(f.readline())#колво людей которые хотят сдать sum ix
a=sorted([list(map(int,i.split())) for i in f])
#в а у нас лежит запрос, в запросе лежит 2 числа
# первое - время сдачи, второе - время возвращения
#print(a)
# сортедом отсортировали
sw=[]#узнав время последнего принятого реквеста создаем список, сложим туда все номера ячеек у которых значение принятия реквеста равно последнему принятому реквесту
c=0
mx=0
for j in range(k):# по сути делаем историю ячеек
    t=[a[0]]
    a.pop(0)
    #print(t)
    l=[]
    for i in range(len(a)):
        if a[i][0]>t[-1][1]:
            t.append(a[i])
            l.append(i)
            mx=max(mx,a[i][0])# тут мы запоминаем последний принятый реквест
            if a[i][0]==998: #узнав из mx что последний принятый реквест был на 998, добавляем в sw номер ячейки в которую определили реквест 
                sw.append(j+1)
    for i in l:
        a.pop(i)
    c+=len(t)
    # if t[-1][0]==998:
    #     print(t[-1])
    #     print(j+1)# тут азнаем номер последней занятой ячейки
    #     break
    
    print(j+1,t)
print(c)# ОТВЕТ В ПУНКТЕ А 344 (сока пассажиров сдало багаж)
print(mx)# нашли время сдачи последнего багажа - 998
#номер ячейки к пункту в - 31
print(sw)#[31, 53], тк просили в случае двух ячеек ячейку с наименьшим номером мы вынуждены проверять, вдруг было несколько реквестов в момент когда приняли последний...

