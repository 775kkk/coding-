f=open("decisions_ege_2024/dataFile/27-37b__33t98.txt")
n=int(f.readline())
a = [int(i) for i in f]
fa=[0]*10001
sm=[0]*20002
rs=0
for i in range(n-2):
    fa[a[i]]+=1;
    # sm[a[i+1]:]+=[x1 for x1 in fa[:10001-a[i+1]]]
    for j in range(10001-a[i+1]):
        sm[a[i+1]+j]+=fa[j]
    rs+=sm[a[i+2]]
print(rs)