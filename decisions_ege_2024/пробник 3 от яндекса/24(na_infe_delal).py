f=open("decisions_ege_2024/пробник 3 от яндекса/24.txt")
a=f.readline()
mx=c=0
for i in range(0,len(a),3):#тут я меняю нач точку, либо 0 л 1 л 2
    if a[i:i+3]==("ABA"or"BAB"):
        c+=1
        mx=max(mx,c)
    else:
        c=0
print(mx)
# 0 1 2
# 3 4 4