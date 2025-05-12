def pB(V, k):  # Dados: vetor V ordenado, inteiro k
    c = 0
    f = len(V) - 1

    while c <= f:
        i = (c + f) // 2
        if V[i] == k:
            return i
        elif V[i] > k:
            f = i - 1
        else:
            c = i + 1

    return -1  # Retorna -1 se não encontrou a chave

# Exemplo de uso:
V = [1, 3, 5, 7, 9, 11]
k = 7

indice = pB(V, k)

if indice != -1:
    print(f"A chave {k} foi encontrada na posição {indice}")
else:
    print(f"O vetor não possui a chave {k}")