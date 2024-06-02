f=open("decisions_ege_2024/dataFile/17_2977.txt")
a=[int(i) for i in f]
c=x=0
for i in range(len(a)-1):
    if ((a[i]**0.5)%2==0) and ((a[i+1]**0.5)%2==0):
        x=max(x,a[i]+a[i+1])
        c+=1
        print(a[i],a[i+1])
print(x,c)