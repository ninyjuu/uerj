linhas= int(input('linhas: '))
colunas= int(input('colunas: '))
m= []
for i in range(linhas):
    linha= []
    for j in range(colunas):
        n= int(input('elemento: '))
        linha.append(n)
    m.append(linha)

transposta= []
for j in range(colunas):
    linha2= []
    for i in range(linhas):
        linha2.append(m[i][j])
    transposta.append(linha2)

for linha2 in transposta:
    print(linha2)

