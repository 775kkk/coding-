from functools import lru_cache

@lru_cache(None)
def f(n):
    if n>2024:
        return 1
    return f(n+2)+f(n+4)
c=0
fm=0
for x in range(3000,1,-1):
    print(x,f(x))
    if fm!=f(x):
        c+=1
    fm=f(x)
print(c)