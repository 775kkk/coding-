
 # поиск делителей числа
x = 616
c = 1
for i in range(1, (x//2)+1): # больше половины числа число делится только на само себя
    if x % i == 0 :
        print(i)
        c += 1 # 0 1 2 3 4 5 6 7 8 9 - цыфры
print(c)