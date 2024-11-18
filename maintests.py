stroka = "abbsb sbbwbsw swbsbws"
stroka = stroka.split();
m = [list((i,stroka.count(i)))for i in stroka]
print(stroka)
print(m)


rows = 3
cols = 4

matrix = [list(range(i*cols, (i+1)*cols)) for i in range(rows)]
print(matrix)
