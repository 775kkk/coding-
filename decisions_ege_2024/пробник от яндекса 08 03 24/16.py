from functools import lru_cache
@lru_cache(None)
def f(n):
    if n<=1:
        return 1#сам исправил тут 0.5 на 1, тк в
    #условии задачи сказано что n - натуральное
    # а при подстановке оригинального кода выводилось nan, что
    # значит "nan" (Not a Number) как результат деления очень больших чисел.
    return(n+1)*f(n-1)
print(f(200)/f(198))