def f(x):
    s=""
    while x>0:
        s+=str(x%4)
        x//=4
    return s[::-1]
for x in range(200,1,-1):
    if f(x)[-3:]=="123":
        print(x,f(x))

    