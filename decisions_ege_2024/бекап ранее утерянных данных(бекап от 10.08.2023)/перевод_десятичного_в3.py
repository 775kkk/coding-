def b3(x) :
    s = ""
    while x > 0 :
        s = str( x % 3) + s
        x //= 3
    #print(s)
    return s # ретурн это вывод какогото значения из нашей ДЕФ
print(b3(124))
