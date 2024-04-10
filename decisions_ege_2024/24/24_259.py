# 259) Текстовый файл 24-259. txt состоит не более чем из 10^6 
# символов и содержит только символы A, T, G, C. 
# Найдите длину наибольшей цепочки символов, 
# которая начинается с ATG, заканчивается на TAA и МЕЖДУ этими 
# группами символов не содержит цепочек TAA, TGA и TAG.

f=open("decisions_ege_2024/dataFile/24-259__3ba5z.txt").readline()
mx=0
t=-1
for i in range(len(f)):
    if f[i:i+3]=="ATG":
        if t!=-1:
            continue
        else:
            t=i
    if (f[i:i+3]=="TAA") and(t>-1):
        mx=max(mx,i-t+3)
        t=-1
    if (f[i:i+3]in["TAA","TGA","TAG"]) and (t!=-1) and(i-t>=3):
        t=-1
print(mx)#124

mx=0
t=-1
for i in range(len(f)):
    if f[i:i+3]=="ATG":
        # t=i
        for j in range(i+2,len(f)):
            if (f[j:j+3]=="TAA"):
                # mx=max(mx,j-i+1)
                if (j-i+3)>mx:
                    mx=j-i+3
                    s=f[i:j+3]
                # t=-1
                break
            if f[j:j+3]in["TGA","TAG"]:
                # t=-1
                break
print(mx)#124