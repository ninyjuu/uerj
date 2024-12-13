#Em uma lista de números inteiros, encontre o segundo
#maior número sem utilizar funções prontas do Python e imprima

lista= []

for i in range (0,5):
    n= int(input('numero: '))
    lista.append(n)
    
maior= lista[0]

for j in range (len(lista)):
    if lista[j]> maior:
        maior= lista[j]
print(maior)

smaior= lista[0]

for k in range (len(lista)):
    if lista[k]!= maior and lista[k]> smaior:
        smaior = lista[k]
        
print(smaior)
