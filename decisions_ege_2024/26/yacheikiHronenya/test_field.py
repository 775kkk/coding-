f=open("decisions_ege_2024/dataFile/26-111__2s4jp.txt")
k=int(f.readline())
n=int(f.readline())
a=sorted([list(map(int,i.split())) for i in f])
a1=a
fs=[]
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
            mx=max(mx,a[i][0])
    for i in l:
        a.pop(i)
    c+=len(t)
    fs.append(t)
    print(j+1,t)
print(c)
print(mx)
