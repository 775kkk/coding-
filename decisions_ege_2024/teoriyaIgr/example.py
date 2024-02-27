def f(x):
    if x>=33:
        return 0
    t = [f(x+3),f(x*2)]
    n = [s for s in t if s<=0]
    if n:
        return -max(n)+1
    else:
        return -max(t)
for i in range(1,33):
    if f(i)==:
        print(i)