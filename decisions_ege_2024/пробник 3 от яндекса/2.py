print("x y z w f")
for x in range(2):
    for y in range(2):
        for z in range(2):
            for w in range(2):
                if ((1==w)==(not((w and x) or y)))<=z:
                    print(x,y,z,w, "1")
                if (((1==w)==(not((w and x) or y)))<=z)==0:
                    print(x,y,z,w, "0")
                    

# x y z w f
# -0 0 0 0 1
# 0 0 1 0 1
# 0 0 1 1 1
# 0 1 0 1 1
# 0 1 1 0 1
# 0 1 1 1 1
# 1 0 0 0 1
# 1 0 0 1 1
# 1 0 1 0 1
# 1 0 1 1 1
# 1 1 0 1 1
# 1 1 1 0 1
# 1 1 1 1 1

# 0 0 0 1 0
# 0 1 0 0 0
# 1 1 0 0 0