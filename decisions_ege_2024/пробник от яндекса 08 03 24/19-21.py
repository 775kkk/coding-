from functools import lru_cache
@lru_cache(None)
def f(x):
    if x>229:
        return 0
    t=[f(x+2),f(x+3),f(x*2)]
    n=[i for i in t if i<=0]
    if n:
        return -max(n)+1
    else:
        return -max(t)
for s in range(1,229):
    if f(s)==-1:
        print(s)