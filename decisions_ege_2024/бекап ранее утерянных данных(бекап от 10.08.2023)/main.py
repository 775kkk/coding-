def b3(x) :
    s = ""
    while x > 0 :
        s = str( x % 2) + s
        x //= 2
    return s
n = int(input())
f = b3(n)
f1 = str(f)[-1]
digits_sum = sum(int(digit) for digit in str(f1))
if digits_sum % 2 == 0 :
    f2 = str(f1)+ "1"
else:
    f2 = str(f1) + "0"
digits_sum1 = sum(int(digit1) for digit1 in str(f2))
while digits_sum1 % 2 == 0 :
    f2 = str(f2) + "1"
    digits_sum1 = sum(int(digit1) for digit1 in str(f2))
R = int(f2)
print(R)
def b10(x) :
    s = ""
    while x > 0 :
        s = str( x % 10) + s
        x //= 10
    return s
print(b10(R))