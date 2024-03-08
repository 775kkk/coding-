a="ГИПЕРБОЛА"
c="ГПРБЛ"
b="ИЕОА"
f=0
for x1 in "ГПРБЛ":
    for x2 in a:
        for x3 in a:
            for x4 in a:
                for x5 in a:
                    for x6 in "ГПРБЛ":
                        s=x1+x2+x3+x4+x5+x6
                        for i in c:
                            s=s.replace(i, "1")
                        for i in b:
                            s=s.replace(i, "0")
                        if  "101" not in s:
                            f+=1
                            # print(s)
print(f)
# 68025
