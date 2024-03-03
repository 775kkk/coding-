f=open("decisions_ege_2024/dataFile/26-111__2s4jp.txt")
k=int(f.readline())
n=int(f.readline())
a=sorted([list(map(int,i.split())) for i in f])
a1=a
print(a[0])
sw=[]
c=0
mx=0
for j in range(k):
    t=[a[0]]
    a.pop(0)
    l=[]
    for i in range(len(a)):
        if a[i][0]>t[-1][1]:
            t.append(a[i])
            l.append(i)
            if a[i][0]==a1[-1][0]:
                print(j+1)
            # mx=max(mx,a[i][0])
            # if a[i][0]==998:
            #     sw.append(j+1)
    for i in l:
        a.pop(i)
    c+=len(t)
    #print(j+1,t)

print(c)# ОТВЕТ В ПУНКТЕ А 344 (сока пассажиров сдало багаж)
print(mx)# нашли время сдачи последнего багажа - 998
#номер ячейки к пункту в - 31
print(sw)
print(a1[-1])
#31 [998, 1338]
#53 [998, 1338]