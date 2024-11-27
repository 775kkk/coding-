baseLines=["X0X","000"]
retM=[""]*(len(baseLines)**2)
f=0
for j in range(len(baseLines)):
    for k in baseLines[j]:      # X0X, 000
        if k=="X":
            #   РИСУЕМ СЕГМЕНТ
            i=f
            while i!=len(baseLines)+f:
                i+=1
                for ik in baseLines:# И for i in range(f,len(baseLines)+f) 
                    retM[i]+=ik+" "
        if k=="0":
            #  НЕ РИСУЕМ СЕГМЕНТ
            for i in range(f,len(baseLines)+f):
                retM[i]+="-"*len(baseLines)+" "
    f+=len(baseLines)


for i in range(len(retM)):
    print(retM[i])