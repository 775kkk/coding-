
# Задача 1. два числа это длина и ширина прямоугольника нарисовать прямоугольник из иксов

def risyemRect(row,col):
    field=[]#row=len
    # field.append(str(i)+" " for i in range(0,col+1))
    field.append("".join(str(i)+" " for i in range(0,col+1)))
    for i in range(1,row+1):
        field.append(str(i)+" "+"z "*col)
    for i in range(len(field)):
        print(field[i])
        
# risyemRect(5,5)

# ///////////--------->


# Задача 2. допом дается 2 числа это корды места где должен быть ноль

def risyemRect(row,col,rowTO,colTO):
    field=[]#row=len
    field.append("".join(str(i)+" " for i in range(0,col+1)))
    for i in range(1,row+1):
        field.append(str(i)+" "+"z "*col)
    #zamena
    field[rowTO]=field[rowTO][:(colTO*2)]+"0"+field[rowTO][(colTO*2)+1:]
    #===
    for i in range(len(field)):
        print(field[i])

risyemRect(5,5,3,3)

# ///////////--------->

# Задача 3 
# Входят данные формата 
# Х0
# 0Х


# Значит в поле 2на2 ты должен нарисовать 
# Х0 --
# 0X --
# -- Х0
# -- 0Х
# допом можно ввести n которое типа будет масштабом т е если n=2+2 то 
# Х0 -- X0 -- -- -- -- --
# 0X -- 0X -- -- -- -- --
# -- X0 -- X0 -- -- -- --
# -- 0X -- 0X -- -- -- --
# -- -- -- -- Х0 -- Х0 -- 
# -- -- -- -- 0Х -- 0X --
# -- -- -- -- -- Х0 -- X0
# -- -- -- -- -- 0Х -- 0X
# если n=2 То
# Х0 -- -- --
# 0X -- -- --
# -- X0 -- --
# -- 0X -- --
# -- -- X0 -- 
# -- -- 0X --
# -- -- -- X0
# -- -- -- 0X


def kybikPrikolov(stroka1,stroka2,n):

    if (len(stroka2)!=len(stroka1)):
        print("введены неверные данные (длина строк не равна")
        return 0
    if n in None or not isinstance(n, int):
        n=len(stroka1)
    RETURNfield=[]
    baseField=[]
    baseLines=list().append(stroka1).append(stroka2)# ТК КОЛВО СТРОК ВСЕГО "2"!!!!!!!!!!!!!!
    # n = 3 =-> --- --- --- 
    #           --- --- ---
    # от n зависит длина од#####ной строки
    for i in baseLines:
        len1=""
        # X0X
        # X0X
        for j in range(len(i)):
            if stroka1[j]=="X":
                len1.join(i+" ")
            elif():
                len1.join("-"*len(i) + " ")
        baseField.append(len1);
        # ROW = 2 CONST
    
    #время масштабироваться
    # ^$&$@*$@*9 РАСШИРЕНИЕ ТЕРРИТОРИИ ?;"?*№:_)"!"
     
    # подготовим альтернативу --- --- ---
    altBASEfield=list("".join("-"*i +" " for j in range(len(stroka1)) for i in range(stroka1)))
    
