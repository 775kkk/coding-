#проверка что число простое:
def prostoe_or_net(x):# from "decisions_ege_2024\exampleConstructions.py"
    for i in range(2, int(x**0.5)+1):
        if x%i==0:
            return False
    if x==1 or x==0:
        return False
    return True
#❗️❗️❗️❗️
# сумма цифр числа
def sum_sufor(x):
    x1=str(abs(x))
    x2=0
    for i in range(len(x1)):
        x2+=int(x1[i])
    return x2