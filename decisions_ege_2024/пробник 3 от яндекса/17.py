f=open("decisions_ege_2024/пробник 3 от яндекса/17.txt")
a=[int(i) for i in f]
a1=[i for i in a if len(str(a))==3]
mx3=max(a1)
print(max(a1),mx3)
