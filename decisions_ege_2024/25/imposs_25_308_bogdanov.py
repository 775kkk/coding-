# 308) (А. Богданов) Назовём маской числа последовательность цифр, 
# в которой может встречаться символ «#», означающий любое число, 
# которое делится без остатка на куб суммы своих цифр. 
# Среди натуральных чисел, не превышающих 10^10, найдите все числа, 
# соответствующие маске 1234#, делящиеся на 137 без остатка. 
# В ответе запишите все найденные числа в порядке
# возрастания, справа от каждого числа - частное от его деления на 137.

# print(12340%137)
# print(12340+127)
# print(12467 %137)

for i in range(12467,10**10,137):
    s=str(i)
    sm=sum(int(x) for x in s[4:])**3
    if sm>0:
        if (int(s[4:])%sm==0) and (s[:4]=="1234"):
            print(i, i//137)