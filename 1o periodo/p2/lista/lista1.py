#Dada uma lista de dez números inteiros, calcule a soma dos
#números nas posições ímpares da lista e imprima o resultado

lista=[]
soma= 0
for i in range (0,10) :
    n= int(input( 'insira um número: '))
    lista.append(n)
for j in range(len(lista)):
    if j%2!=0:
        soma+= lista[j]
print(soma)
