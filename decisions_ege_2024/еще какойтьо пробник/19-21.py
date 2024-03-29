def f(x):
    if x>=435:
        return 0
    t=[f(x+5),f(x*3)]
    n=[i for i in t if i<=0]
    if n:
        return -max(n)+1
    return -max(t)
xod= -2 ;
for i in range(1,435):
    if f(i)== xod:
        print(i,xod)