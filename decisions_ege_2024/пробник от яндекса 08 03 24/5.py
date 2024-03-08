for n in range(1000,10000):
    a=[i for i in str(n)]
    mx1=max(int(i) for i in a)
    mn1=min(int(i) for i in a)
    a.remove(str(mx1))
    a.remove(str(mn1))
    mg=int(a[0])*int(a[-1])
    a1=[]
    a1.append(mx1+mn1)
    a1.append(mg)
    r=""
    while a1:
        r+=str(min(a1))
        a1.remove(min(a1))
    # print(r)
    # rs=[]
    if int(r)>85:
        # rs.append(n)
        print(n,r)
        break
# print(min(rs))
        
