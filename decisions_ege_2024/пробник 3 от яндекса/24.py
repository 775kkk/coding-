#  C10C10101010C01 
#  010    101 
f=open("decisions_ege_2024/пробник 3 от яндекса/24.txt")
a=f.readline()
# a=a.replace("A","1")
# a=a.replace("B","0")
mx1=mx2=c=0
for i in range(len(a)-2):
    if "ABA" in a[i:i+3]:
        c+=1
        for j in range(i+3,len(a)-2):
            if "ABA" in a[j:j+3]:
                c+=1
            else:
                mx1=max(mx1,c)
                c=0
                break
    if "BAB" in a[i:i+3]:
        c+=1
        for j in range(i+3,len(a)-2):
            if "BAB" in a[j:j+3]:
                c+=1
            else:
                mx2=max(mx2,c)
                c=0
                break
print(mx1,mx2)
# ABAABAABAABA 4
        # 3
