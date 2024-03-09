
f = open('C:/Users/admin\Desktop\пайчарм проджект\цепочка символов/24__1zitr.txt')
s = f.readline()
l = lmax = 0
'''
fn = 0
for i in range(len(s)) :
    if s[i] == "E":
        l += 1
        if l >= lmax :
            lmax = l
            fn = i-l
    else:
        l = 0
print(lmax, fn)
'''
t = [ "AAA"]
for i in range(0, len(s), 3):
    if s[i:i+3] in t :
        l += 1
        if l >= lmax:
            lmax = l
    else:
        l = 0
print(lmax)

