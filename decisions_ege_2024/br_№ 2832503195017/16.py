from functools import lru_cache
@lru_cache(None)
def f(x):
    if x<=1:
        return 1
    if (x%2==0) and (x>1):
        return 3*x + f(x-1)
    return 2*f(x-2)
print(f(31))
print((36**0.5)%2==0)