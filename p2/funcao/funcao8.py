#ver maior usando float('-inf')

def maior (linhas,colunas):
    dic={}
    m=[]
    for i in range(linhas):
        linha= []
        for j in range(colunas):
            n= int(input('elemento: '))
            linha.append(n)
        m.append(linha)

    maior= float('-inf')
    for linha in m:
        for i in linha:
            if i > maior:
                 maior= i
    return maior

l= int(input('linhas: '))
c= int(input('colunas: '))
print(maior(l,c))

