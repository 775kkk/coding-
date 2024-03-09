a="КАБИНЕТ"
b="КБНТ"
c=0
for x1 in a:
    for x2 in a:
        for x3 in a:
            for x4 in a:
                for x5 in a:
                    for x6 in a:
                        for x7 in b:
                            s=x1+x2+x3+x4+x5+x6+x7
                            if len(set(i for i in s))==7:
                                c+=1
                                # print(s)        
print(c)