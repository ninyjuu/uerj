linhas= int(input('linhas: '))
colunas= int(input('colunas: '))
m=[]
for i in range(linhas):
    linha= []
    for j in range(colunas):
        n= int(input('numero '))
        linha.append(n)
    m.append(linha)
for linha in m:
    print(linha)