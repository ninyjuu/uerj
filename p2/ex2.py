#Em uma lista de números inteiros, encontre o segundo
#maior número sem utilizar funções prontas do Python e imprima

lista= []
maior= 0
smaior= 0

for i in range (0,5):
    n= int(input('numero: '))
    lista.append(n)

for j in range (len(lista)):
    if lista[j]> maior:
        maior= lista[j]
lista.remove(maior)
print(maior)

for k in range (len(lista)):
    if lista[k]> smaior:
        smaior = lista[k]
        
print(smaior)