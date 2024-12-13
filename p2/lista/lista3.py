#Dada uma lista de dez números inteiros, substitua todos
#os números negativos por zero. Imprima a lista resultante.

lista= []
for i in range(0,10):
    n= int(input('insira um número: '))
    lista.append(n)

for j in range(len(lista)):
    if lista[j] < 0:
        lista[j]= 0
print(lista)

