from fnmatch import *

for i in range(0,10**10,7181): 
    s=str(i)
    if fnmatch(s,"12?345*9"):
        print(i,i//7181)