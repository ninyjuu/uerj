#contagem na matriz

def matriz (x):
    m= []
    for i in range(x):
        linha= []
        for j in range(x):
            n= int(input('numero: '))
            linha.append(n)
        m.append(linha)
    escolha= int(input('escolhido: '))
    cont=0
    for linha in m:
        cont+= linha.count(escolha)
    return cont
    
n= int(input('numero linha/coluna: '))
print(matriz (n))


    

        