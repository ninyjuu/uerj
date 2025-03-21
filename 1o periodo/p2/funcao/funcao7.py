#repeticoes em uma lista de números

def repeticao(lista):
    dic={}
    for i in lista:
        if i not in dic:
            dic[i]=1
        else:
            dic[i]+=1
    return dic

numeros=[]
while True:
    n=int(input('numero: '))
    if n <0:
        break
    numeros.append(n)

print(repeticao(numeros))

