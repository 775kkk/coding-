for n in range(1,300):
    n1=bin(n)[2:]
    if n1.count("1")%2==0: n1=n1+"1"
    if n1.count("1")%2!=0: n1=n1+"0"
    if n1.count("1")%2==0: n1=n1+"1"
    if n1.count("1")%2!=0: n1=n1+"0"
    r=int(n1,2)
    if r>54:
        print(n,r)
        break

