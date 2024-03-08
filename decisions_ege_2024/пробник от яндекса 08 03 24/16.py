from functools import lru_cache
@lru_cache(None)
def f(n):
    if n<=1:
        return 1
    return(n+1)*f(n-1)
print(f(200)/f(198))