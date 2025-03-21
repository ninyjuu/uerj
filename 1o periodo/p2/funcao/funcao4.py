#soma diagonal secundaria

def matriz (x):
    m= []
    for i in range(x):
        linha= []
        for j in range(x):
            n= int(input(f'insira o numero [{i}][{j}]: '))
            linha.append(n)
        m.append(linha)
    return m

def soma_sec(m):
    n= len(m)
    soma=0
    for i in range(n):
        soma+=m[i][n-i-1]
    return soma


n= int(input('numero de linhas/ colunas: '))
result= matriz(n)
print(soma_sec(result))
