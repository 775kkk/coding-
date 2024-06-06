def prosrt(x):
    for i in range(2,int(x**0.5)+1):
        if x%i==0:
            return False
    return True

for i in range(102714,102726):
    c=set()
    for x in range(2,int(i**0.5)+1):
        if i%x==0:
            if prosrt(x):
                c.add(x)
            if prosrt(i//x):
                c.add(i//x)
    if len(c)==2 :
        print(c)
