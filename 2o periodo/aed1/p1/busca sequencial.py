def busca(V, k):
    i = 0
    while i < len(V) and V[i] != k:
        i += 1
    if i < len(V):
        return i + 1 
    else:
        return None

V = [4, 8, 1, 7, 3]
k = 7

p = busca(V, k)

if p is not None:
    print(f"Encontrou {k} na posição {p}")
else:
    print(f"{k} não foi encontrado no vetor")
