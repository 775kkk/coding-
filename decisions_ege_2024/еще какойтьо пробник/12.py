mx=0
def f(x):
    x1=str(x)
    c=0
    for i in range(len(x1)):
        c+=int(x1[i])
    return c

# print(f("1231"))

for n in range(4,1000):
    s="8"+"4"*n
    while ("11" or "444" or "8888") in s:
        if "11"in s:
            s=s.replace("11","4",1)
        if "444"in s:
            s=s.replace("444","88",1)
        if "8888"in s:
            s=s.replace("8888","1",1)
    mx=max(mx,f(s))
print(mx)
        # 4004