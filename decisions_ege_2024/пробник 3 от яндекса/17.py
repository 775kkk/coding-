f=open("decisions_ege_2024/пробник 3 от яндекса/17.txt")
a=[int(i) for i in f]
a1=[i for i in a if len(str(abs(i)))==3]
mx3=max(a1)**3
c=0
def f(x):
    x1=str(abs(x))
    x2=0
    for i in range(len(x1)):
        x2+=int(x1[i])
    return x2
# print(f(21))
mxs=0
for i in range(len(a)-1):
    h=0
    if f(a[i])%5==0:
        h+=1
    if f(a[i+1])%5==0:
        h+=1
    if h==1 and abs((a[i]**2)-(a[i+1]**2))>mx3:
        c+=1
        mxs=max(mxs,a[i]+a[i+1])
print(c, mxs)

