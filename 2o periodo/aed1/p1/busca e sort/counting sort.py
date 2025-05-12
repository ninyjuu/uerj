def contagem_com_vs(V1, p):
    # Etapa 1: Criar vetor de frequências (VS) e zerar
    VS = [0] * (p + 1)

    # Etapa 2: Contar quantas vezes cada valor aparece
    for i in range(len(V1)):
        VS[V1[i]] += 1

    # Etapa 3: Criar vetor de posições acumuladas (VA)
    VA = [0] * (p + 1)
    VA[1] = VS[1]
    for i in range(2, p + 1):
        VA[i] = VS[i] + VA[i - 1]

    # Etapa 4: Ordenar no vetor V2
    V2 = [0] * len(V1)
    for i in range(len(V1) - 1, -1, -1):
        valor = V1[i]
        posicao = VA[valor]
        V2[posicao - 1] = valor
        VA[valor] -= 1

    return V2
