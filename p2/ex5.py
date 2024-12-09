#Separar Pares e Ímpares: Peça ao usuário para inserir uma
#lista de números inteiros. Escreva um programa que separe os números
#pares e ímpares em duas listas diferentes e exiba ambas.

lista=[]
listapar=[]
listaimpar=[]
for i in range(5):
    n= int(input('numero: '))
    lista.append(n)
for i in lista:
    if i%2==0:
        listapar.append(i)
    else:
        listaimpar.append(i)
print(listapar,listaimpar)