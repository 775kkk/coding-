from functools import lru_cache

@lru_cache(None)
def f(a,b):
    if a>b:
        return 0
    if a==25:
        return 0
    if a==b:
        return 1
    if a<b:
        return f(a+3,b)+f(a*2,b)+f(a*5,b)
print(f(5,115))#98
# не проходя через 25
# от 5 до 115 с командами
# +3 *2 *5