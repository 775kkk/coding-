f=open("decisions_ege_2024/еще какойтьо пробник/24.txt")
a=f.readline()
a=a.replace("KLMN","*")
mx=0
for i in range(len(a)):
    c=0
    if (a[i:i+3]==("LMN")):# or (a[i:i+2]=="MN") or (a[i]=="N"):
            c+=3
            for j in range(i+3,len(a)):
                if a[j]=="*":
                    c+=4
                else:
                    if a[j:j+3]=="KLM":
                        c+=3
                        mx=max(mx,c)
                        break
                    if a[j:j+2]=="KL":
                        c+=2
                        mx=max(mx,c)
                        break
                    if a[j]=="К":
                        c+=1
                        mx=max(mx,c)
                        break
                    else: 
                         mx=max(mx,c)
                         break
    elif (a[i:i+2]=="MN"):
        c+=2
        for j in range(i+2,len(a)):
                if a[j]=="*":
                    c+=4
                else:
                    if a[j:j+3]=="KLM":
                        c+=3
                        mx=max(mx,c)
                        break
                    if a[j:j+2]=="KL":
                        c+=2
                        mx=max(mx,c)
                        break
                    if a[j]=="К":
                        c+=1
                        mx=max(mx,c)
                        break
                    else: 
                         mx=max(mx,c)
                         break
    elif (a[i]=="N"):
        c+=1
        for j in range(i+1,len(a)):
                if a[j]=="*":
                    c+=4
                else:
                    if a[j:j+3]=="KLM":
                        c+=3
                        mx=max(mx,c)
                        break
                    if a[j:j+2]=="KL":
                        c+=2
                        mx=max(mx,c)
                        break
                    if a[j]=="К":
                        c+=1
                        mx=max(mx,c)
                        break
                    else: 
                         mx=max(mx,c)
                         break
    elif (a[i]=="*"):
        c+=4
        for j in range(i+1,len(a)):
                if a[j]=="*":
                    c+=4
                else:
                    if a[j:j+3]=="KLM":
                        c+=3
                        mx=max(mx,c)
                        break
                    if a[j:j+2]=="KL":
                        c+=2
                        mx=max(mx,c)
                        break
                    if a[j]=="К":
                        c+=1
                        mx=max(mx,c)
                        break
                    else: 
                         mx=max(mx,c)
                         break
print(mx)# 182
# даже без учёта окончаний на klm or kl or k получается 182
# изначально я просто про окончания забыл