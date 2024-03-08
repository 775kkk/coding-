print("a b c d")
for a in range(2):
    for b in range(2):
        for c in range(2):
            for d in range(2):
                # if (((a and b)<=c) and((b and c)<=d))==0:
                #     print(a,b,c,d)
            # по формуле де-моргана
                if ((not(a)or not(b) or c)and(not(b) or not(c) or d))==0:
                    print(a,b,c,d)
