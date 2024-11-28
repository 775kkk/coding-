from functools import lru_cache

@lru_cache(None)
def kybikPrikolov(stroki,n):

    baseLines=stroki.split(",")
    if len(set(len(line) for line in baseLines)) > 1:
        print("введены неверные данные (длина строк не равна)")
        return 0
    #3
    if n<1:
        n=1
        # return baseLines
    
    if n==1:
        retM=[""]*(len(baseLines)**(n+1))
        f=0
        for j in range(len(baseLines)):
            for k in baseLines[j]:      # X0X, 000
                if k=="X":
                    #   РИСУЕМ СЕГМЕНТ
                    i=f
                    for ik,i in zip(baseLines,range(f,len(baseLines)+f)):
                            retM[i]+=ik+" "
                if k=="0":
                    #  НЕ РИСУЕМ СЕГМЕНТ
                    for i in range(f,len(baseLines)+f):
                        retM[i]+="-"*len(baseLines[0])+" "
            f+=len(baseLines)
        return retM
    else:#              3**2*3
        retM=[""]*((len(baseLines)**2)*len(baseLines))
        # масштаб(n) больше базы
        # значит тупа конструируем масштабик из базы
        nowROW=0
        for j in range(len(baseLines)):
            
            for k in baseLines[j]:
                if k=="X":#1
                    # ЗАПОЛНЯЕМ СЕГМЕНТ НИЗШЕВЫМИ СЕГМЕНТАМИ ИЗ kybikPrikolov(stroki,n-1)
                    for ik,i in zip(kybikPrikolov(stroki,n-1),range(nowROW,(len(baseLines)**2)+nowROW)):
                        retM[i]+=ik+" "
                if k=="0":
                    strokNULL="".join(("0"*len(baseLines[0]))+"," for i in baseLines)
                    strokNULL=strokNULL[:-1]
                    for ik,i in zip(kybikPrikolov(strokNULL,n-1),range(nowROW,(len(baseLines)**2)+nowROW)):
                        retM[i]+=ik+" "

            nowROW+=len(baseLines)**2
        return retM

retm= kybikPrikolov("0XX0,X0XX,X0XX",2)
for i in range(len(retm)):
    print(retm[i])









    #1
    # есть идея тупо ебануть списочек с сегментами и где один там красить 1 0 1 0 1 0
                    # рисуем по строку : baseSIGMENTrow**(n+1)/(baseSIGMENTrow**(n+1)/baseSIGMENTrow**n) 
                    #                                2**1/(2**2)/2 = 2
                    #           СЕГМЕНТ ЭТО ОТРИСОВКА СТРОКИ ПО ТРЕБОВАНИЮ ДАННОЙ СТРОКИ В РАЗМЕЖОВКЕ
                    # Пример :
                    # дано :
                    # X0,0X,n=1
                    # получается :
                    # X0 --         ==> начало первого сегмента по требованию первой строки
                    # 0X --         ==> конец первого сегмента по требованию первой строки
                    # -- X0         ==> начало Второго сегмента по требованию Второй строки
                    # -- 0X         ==> конец ВТорого сегмента по требованию Второй строки
                    # по идее крч тут еще по столбец и рекурсией внутрь передать чтобы внутри сегмента все отрисовать
                    # и так каждый сегмент по этим двум циклам выше но я хз как упаковать данные
                    # //////////////////////////////////////////

    #3
        # if n in None or not isinstance(n, int):
    #     n=1

    #  16 : 16/2 = 2 -> мельчайший сегмент ; если строк 2(басе сигмент) и зум 3(n)
    #  басе сегмент**(зум+1)/(басе сегмент**(зум+1)/басе сегмент**зум) = мельчайший сегмент = басе сегмент
    #  2**(3+1)/(2**(3+1)/2**3) = 2
    #  16/(16/8)=2 = колво строк
    #  baseSIGMENTrow**(n+1)/(baseSIGMENTrow**(n+1)/baseSIGMENTrow**n)

    # сегмент зума
    # басе сегмент строк**(зум+1) = всего строк при зуме
    # басе сегмент строк**(зум+1)/басе сегмент строк*(зум-зум+1) = первый сегмент текущего зума
    # басе сегмент строк**(зум+1)/басе сегмент строк*(зум-зум+2) = второй сегмент текущего зума
    # 3**(3)/3*(1)=3
    #                                       и так пока зум-зум+i!=зум
    #                                       сегментов всегда столько сколько строк на вход поступило
