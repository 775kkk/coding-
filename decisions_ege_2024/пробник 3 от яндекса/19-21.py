from functools import lru_cache
@lru_cache(None)
def f(x,b):
    if x+b>=189:
        return 0
    t=[f(x+b,b),f(x,b+x)]
    if x>b:
        t.append(f(x,x))
    if x<b:
        t.append(f(b,b))
    n=[i for i in t if i<=0]
    if n:
        return -max(n)+1
    else:
        return -max(t)
# print(f(5,3))
for s in range(1,183):
    if f(5,s)==-2:
        print(s)
        # print(f(5,s))