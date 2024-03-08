# 1111 1111.1111 1111.1111 1111.111а 0 0000
# 1101 0100.1100 0000.0010 0000.011а 0 0000
s=""
c=0
for i in range(2):
    for i1 in range(2):
        for i2 in range(2):
            for i3 in range(2):
                for i4 in range(2):
                    s="011"+str(i)+str(i1)+str(i2)+str(i3)+str(i4)
                    if ("111" not in s) or ("000" not in s):
                        c+=1
                        print(s)
print(c)