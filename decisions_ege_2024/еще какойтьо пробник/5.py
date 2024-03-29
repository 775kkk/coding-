for n in range(100):
    n1=bin(n)[2:]
    if n%3==0:
        n1+=n1[-2:]
    if n%3!=0:
        n1+=bin((n%3)*3)[2:]
    r=int(n1,2)
    if r>=195:
        print(n,r)
    # print(n,r)