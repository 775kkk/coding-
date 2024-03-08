print("i , k")
for i in range(650000,10000000000):
    f=set()
    k=0
    for b in range(2,int(i**0.5)+1):
        if i%b==0:
            f.add(b)
            f.add(i//b)
    if len(f)==6:
        k=max(f)+min(f)
        if len(str(k))==4:
            print(i,k)