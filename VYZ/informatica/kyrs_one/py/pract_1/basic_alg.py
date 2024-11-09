# -----1-----
# проверка на простоту числа

def prostoe_or_net(x):
    for i in range(2, int(x**0.5)+1):
        if x%i==0:
            return False
    if x==1 or x==0:
        return False
    return True

# print(prostoe_or_net(11))

# /////////////////////////-----

#-----2-----
#вводится число выводится последовательность совершенных числе до этого числа (ссумма делителей равна числу)

def soversh_spisok(x):
    c=set()
    for i in range(1, int(x**0.5)+1):
        if x%i==0 :
            c.add(i)
            if x/i!=x:
                c.add(x//i)
    # return c
    if sum(c)==x: return c

# print(soversh_spisok(60))

# /////////////////////////-----

#-----3-----
# проверить явл ли число полиндромом

def polindrom(x):
    if str(x)[::-1]==str(x):
        return True
    return False

# print(polindrom(901))
# print(polindrom(4994))

# /////////////////////////-----

#-----4-----
# 