linhas= int(input('numero de linhas: '))
colunas= int(input('numero de colunas: '))
m= []
soma= 0
for j in range(linhas):
    linha= []
    for i in range(colunas):
        n= int(input('insira um numero: '))
        linha.append(n)
        if i == j:
            soma+= n
    m.append(linha)
print(soma)
