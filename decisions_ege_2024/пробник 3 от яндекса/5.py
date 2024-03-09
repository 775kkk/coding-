for n in range(0,100):
    r1=bin(n)[2:]
    if r1[-1]=="0":
        r1=r1+"0"*r1.count("0")
    else:
        r1="1"*r1.count("0")+r1
    # print(n,r1)
    if int(r1,2)>2000:
        print(n,r1,int(r1,2))
