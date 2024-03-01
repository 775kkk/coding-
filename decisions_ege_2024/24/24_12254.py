f = open("decisions_ege_2024/dataFile/24_12254.txt")
s = f.readline()
#s='SQSQSQSRQRSRQRSRQRSRQSRQRSRSRQRSRSQRRSQRSRQRSRQRSQRSQRSQRSQR'
# определение начала цепи по началу потом типа внутри этой цепи мы ищем ее конец
s=s.replace("RSQ", "*")
mx=0
for i in range(len(s)-1):
    c=0
    if (s[i]=="Q") or (s[i]+s[i+1]=="SQ"):
        if (s[i]+s[i+1]=="SQ"):
            c+=2
            for x in range(1,10000):
                if s[i+x]=="*":
                    c+=3
                    if c>mx:
                        mx=c
                elif s[i+x]=="R":
                    c+=1
                    if c>mx:
                        mx=c
                    break     
                elif s[i+x]+s[i+x+1]=="RS":
                    c+=2
                    if c>mx:
                        mx=c
                    break
                else:break
        if (s[i]=="Q"):
            c+=1
            for x in range(1,10000):
                if s[i+x]=="*":
                    c+=3
                    if c>mx:
                        mx=c
                elif s[i+x]=="R":
                        c+=1
                        if c>mx:
                           mx=c
                        break
                elif s[i+x]+s[i+x+1]=="RS":
                    c+=2
                    if c>mx:
                        mx=c
                    break
                else:break
    elif s[i]=="*":
        c+=1
        for x in range(1,10000):
            if s[i+x]=="*":
                c+=3
                if c>mx:
                    mx=c
            elif s[i+x]=="R":
                    c+=1
                    if c>mx:
                        mx=c
                    break
            elif s[i+x]+s[i+x+1]=="RS":
                c+=2
                if c>mx:
                    mx=c
                break
            else:break
print(mx)
