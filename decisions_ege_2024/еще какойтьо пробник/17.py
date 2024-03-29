f=open("decisions_ege_2024/еще какойтьо пробник/17.txt")
a=[int(i) for i in f]
# def f(x):
#     c=0
#     if len(str(abs(x)))==5:
#         c+=1
#     if str(x)[-2:]=="21":
#         c+=1
#     if c==2:
#         return True
#     return False

def ff(x):
    return (len(str(abs(x)))==5)and(str(x)[-2:]=="21")
c1=mx=0
a1=max(i for i in a if ff(i))**2
print(a1)

for i in range(len(a)-1):
    c=0
    if ff(a[i]) :
        c+=1
    if ff(a[i+1]):
        c+=1
    if c==1 and ((a[i]**2+a[i+1]**2)>a1):
        c1+=1
        mx=max(mx,a[i]+a[i+1])
print(c1,mx)
# 74 103365
