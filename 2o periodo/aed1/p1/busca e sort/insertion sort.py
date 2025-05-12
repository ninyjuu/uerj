v= [None, 4,6,3,8,1,5]
for i in range(2, len(v)):
    v[0]= v[i]
    j= i
    while v[j-1]> v[0]:
        v[j]= v[j-1]
        j-= 1
    v[j]= v[0]
print(v[1:])