# 299) (Р. Сорокин) Назовём маской числа последовательность цифр, 
# в которой также могут встречаться следующие символы:
# - символ «@» означает любую последовательность нечетных цифр 
# произвольной длины; в том числе « @» может задавать и пустую последовательность.
# - символ «?» означает одну любую цифру. 
# Например, маске 1@9? соответствуют числа 190, 13591, 1753992. 
# Найдите все натуральные числа, которые не превышают 10^11, 
# соответствуют маске 78?56@321 и делятся на 279. 
# В ответе запишите все найденные числа в порядке возрастания, 
# а справа от каждого число - частное от деления этого числа на 279.

print((70000000+279-16))

for i in range(70000263,10**11,279):
    s= str(i)
    t=[x for x in s[5:-3] if int(x)%2==0]
    if (s[:2]=="78") and (s[3:5]=="56") and(s[-3:]=="321") and (not(t)):
        # if s[5:-3]
        print(s,i//279)