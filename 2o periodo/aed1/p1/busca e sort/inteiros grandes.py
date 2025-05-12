def convIntNG(k):
    B = [0] * 10  # Supondo tamanho fixo de 10 para o vetor B
    if k > 0:
        B[0] = 1
    else:
        B[0] = -1
        k = -k

    for i in range(len(B) - 1, 0, -1):
        B[i] = k % 10
        k = k // 10

    return B
