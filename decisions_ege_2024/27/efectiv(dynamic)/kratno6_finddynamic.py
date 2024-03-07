# найди такие 2 числа чтобы их произведение было максимальным и кратным 6
f=open("decisions_ege_2024/dataFile/27-6b__31m5w (1).txt")
n=int(f.readline())#колво чисел в файле
a=[int(i) for i in f]
m1=m2=m3=m6=mx=0
for i in range(len(a)-1):#-1 тк последний элемент больше несчем сравнивать...
    if a[i]>m1:
        m1=a[i]
    if (a[i]>m2) and (a[i]%2==0):
        m2=a[i]
    if (a[i]>m3) and (a[i]%3==0):
        m3=a[i]
    if (a[i]>m6) and (a[i]%6==0):
        m6=a[i]
    if ((a[i+1]*m1)>mx)and((a[i+1]*m1)%6==0):
        mx=a[i+1]*m1
    if ((a[i+1]*m3)>mx)and((a[i+1]*m3)%6==0):
        mx=a[i+1]*m3
    if ((a[i+1]*m6)>mx)and((a[i+1]*m6)%6==0):
        mx=a[i+1]*m6
    if ((a[i+1]*m2)>mx)and((a[i+1]*m2)%6==0):
        mx=a[i+1]*m2
print(mx)#997002