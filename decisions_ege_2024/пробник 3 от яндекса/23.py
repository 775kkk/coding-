def fs(x):
    x1=str(abs(x))
    x2=0
    for i in range(len(x1)):
        x2+=int(x1[i])
    return x2
def f(x,y):
    if x==y:
        return 1
    if x<y:
        return 0
    if x>y:
        # k=int(str(x**2)[0])
        return f(x-int(str(x**2)[0]),y)+f(x-fs(x),y)
print(f(32,1))

   