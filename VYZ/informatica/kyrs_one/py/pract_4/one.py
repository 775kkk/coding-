
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


def kybikPrikolov(stroka1,stroka2,n):#stroka3,stroka4,stroka5,stroka6,stroka7,stroka8):
    # strok=len(list().append(stroka1).append(stroka2).append(stroka3).append(stroka4).append(stroka5).append(stroka6).append(stroka7).append(stroka8))
    if n in None or not isinstance(n, int):
        n=1
    flag1= True if stroka1[0]=="X" else False
    flag2= True if stroka1[1]=="X" else False
    flag3= True if stroka2[0]=="X" else False
    flag4= True if stroka2[1]=="X" else False
    field=[]
    if not((n%len(stroka1)!=0) or (n==1)) and (len(stroka2)!=len(stroka1)):
        print("введены неверные данные (длина строк ровна и кратка n)")
        return 0
    
    
    
