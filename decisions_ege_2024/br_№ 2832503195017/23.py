from functools import lru_cache

@lru_cache(None)
def f(a,b):
    if a<b:
        return 0
    if a==b:
        return 1
    if a>b:
        return f(a-4,b)+f(a//3,b)
print(f(36,2))