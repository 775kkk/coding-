from functools import lru_cache

@lru_cache(None)
def f(n):
    if n<=3:
        return 2025
    return 3*(n-1)*f(n-2)
# print(f(2027)/f(2023))
# 2023
x1=2025
f1=5
for i in range(1010,3,-1):
    x1*=3*(f1-1)
    f1+=2
# print(x1)
f2=5
x2=2025
for i in range(1012,3,-1):
    x2*=3*(f2-1)
    f2+=2
# print(x2)
print(x2/x1)
# 36687240.0
# задумался на минут 20