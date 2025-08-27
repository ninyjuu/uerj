v= [3,5,12,7,8,1]

def Particione(A,p,r):
    x = A[r]
    i = p-1
    for j in range(p, r):
        if A[j] <= x:
            i += 1
            A[i], A[j] = A[j], A[i]
    A[i+1], A[j] = A[j], A[i+1]
    return A[i+1]

#def QuickSort

print(Particione(v,0,5))
print(v)
