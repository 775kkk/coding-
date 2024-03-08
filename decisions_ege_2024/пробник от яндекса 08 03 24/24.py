f=open("decisions_ege_2024/пробник от яндекса 08 03 24/24.txt")
a=f.readline()
a=a.replace("yandex","*")
a=a.replace("y4nd3x","*")
a=a.replace("yand3x","*")
a=a.replace("y4ndex","*")
mx=0
#вцелом для простоты все ненужные нам символы можно было бы просто заменить на 0
# а потом заменить множества нулей на еденичный экземпляр
for i in range(len(a)):
    if "*"==a[i]:
        c=6
        for j in range(i+1,len(a)):
            if a[j]=="*":
                c+=6
            elif a[j]=="y":
                c+=1
                if a[j+1]==("a"or"4"):
                    c+=1
                    if a[j+2]=="n":
                        c+=1
                        if a[j+3]=="d":
                            c+=1
                            if a[j+4]==("3"or"e"):
                                c+=1
                                mx=max(mx,c)
                                break
                        else:
                            mx=max(mx,c)
                            break
                    else:
                        mx=max(mx,c)
                        break
                else:
                    mx=max(mx,c)
                    break
            else:
                mx=max(mx,c)
                break
print(a)
print(mx)
