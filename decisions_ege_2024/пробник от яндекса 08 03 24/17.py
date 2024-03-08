f=open("decisions_ege_2024/пробник от яндекса 08 03 24/17.txt")
a=[int(i) for i in f]
s=[i for i in a if len(str(i))==3] 
s1=min(s)
s.remove(s1)
s1=min(s)**2
# print(s1)
c=0
mx=0
for i in range(len(a)-1):
    if a[i]+a[i+1]<s1:
        c+=1
        mx=max(mx,a[i]+a[i+1])
print(c,mx)
