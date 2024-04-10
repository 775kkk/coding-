# 287) Текстовый файл 24-280. txt состоит не более чем из 10° 
# символов и содержит только заглавные буквы латинского алфавита.
# Определите максимальное количество идущих подряд символов, 
# среди которых буквы Х и У встречаются ровно по одному разу, 
# а буква А не встречается
# совсем.
f=open("decisions_ege_2024/dataFile/24-280__3ba6k.txt").readline()
# a=f.split("A")
# c=mx=0
# s=""
# for i in a:
#     # x=y=0
#     for j in range(len(i)):
#         # if i[j] =="X":
#         #     x+=1
#         # if i[j]=="Y":
#         #     y+=1
#         # if ((x!=0)and(y!=0))and((x>1)or(y>1)):
#         #     mx=max(mx,j-1)
#         #     break #175, 135 tr

#         # if (i[0:j].count("X")==1) and (i[0:j].count("Y")==1):
#         #     for o in range(j+1,len(i)):
#         #         if i[o]in["X","Y"]:
#         #             # mx=max(mx,len(i[0:o-1]))
#         #             if mx<len(i[0:o]):
#         #                 mx=len(i[0:o])
#         #                 s=i[0:o+1]
#         #             break #тож не то чето 132
#         #     break
        
#         if (i[0:j].count("X")==1) and (i[0:j].count("Y")==1):
#             if (i[0:j].count("X")>=1) or (i[0:j].count("Y")>=1):
#                 if mx<len(i[0:j]):
#                         mx=len(i[0:j-1])
#                         s=i[0:j-1]
#                 break # да ебана 105
# print(mx,s)

# x=y=mx=0
# for i in range(len(f)):
#     if f[i]=="A":
#         t=i+1
#         x=y=0
#         for j in range(i+1,len(f)):
#             if f[j]=="A":
#                 break
#             if f[j]=="X":
#                 x+1
#             if f[j]=="Y":
#                 y+1
#             if (x+y>2)and not("A" in f[t:j-1]):
#                 mx=max(mx, len(f[t:j-1]))
#                 break # 0
# print(mx)

# max_len = 0
# count_X = 0
# count_Y = 0
# seen_A = 0
# c=0
# for char in f:
#     c+=1
#     if char == 'X':
#         count_X += 1
#     if char == 'Y':
#         count_Y += 1
#     if char == 'A':
#         max_len=max(c-1,max_len)
#         c=0
#         count_X=count_Y=0
#     if (count_X==2 or count_Y==2)and(count_Y>0 and count_X>0):
#         max_len=max(c-1,max_len)
#         count_X=count_Y=0
#         if char == 'X':
#             count_X += 1
#         if char == 'Y':
#             count_Y += 1
# print(max_len)
                
a=f.split("A")
c=mx=0
s=""
for i in a:
    i=i.split("X") # spl Y
    for k in range(len(i)-1):
        s=i[k]+i[k+1]
        if s.count("Y")==1: # X
            mx=max(mx,len(s)+1)
print(mx)
# spl x =120
# spl y =132

кароче пошло нах ответ 135 ваще бл у него в решениее(у полякова) ваще блять 193 ответ
я ебу крч это пиздец я бы отввет 132 ебнул а на еге просто бы сплитнутое по а принтанул
с длинной и самые длинные бы нах в ручную проверял

и его решение это ваще блятть какойто хз нах набор символов непонятный ващ половину хз чо такое
