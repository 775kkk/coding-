# 1111 1111.1111 1111.1111 1111.1111 0000
# 1100 0000.1010 1000.0100 1100.1010 0000
c=0
for x5 in range(2):
    for x6 in range(2):
        for x7 in range(2):
            x="1010"+str(x5)+str(x6)+str(x7)+"0"#+str(x8)
            if x.count("1")%2==0 :
                c+=1
                print(x)

