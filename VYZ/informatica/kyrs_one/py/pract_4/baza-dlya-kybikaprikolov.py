baseLines=["X0","0X"]
n=1
retM=[""]*(len(baseLines)**(n+1))
f=0
for j in range(len(baseLines)):
    for k in baseLines[j]:      # X0X, 000
        if k=="X":
            #   РИСУЕМ СЕГМЕНТ
            for ik,i in zip(baseLines,range(f,len(baseLines)+f)):# И for i in range(f,len(baseLines)+f) 
            # while i!=len(baseLines)+f:
            #     i+=1
            #     for ik in baseLines:# И for i in range(f,len(baseLines)+f) 
                    retM[i]+=ik+" "
        if k=="0":
            #  НЕ РИСУЕМ СЕГМЕНТ
            for i in range(f,len(baseLines)+f):
                retM[i]+="-"*len(baseLines[0])+" "
    f+=len(baseLines)

print(retM)
# for i in range(len(retM)):
#     print(retM[i])