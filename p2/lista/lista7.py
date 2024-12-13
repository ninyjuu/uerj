#Dada uma lista de números inteiros, calcule a média dos elementos e conte quantos
#elementos são maiores que essa média. Imprima o resultado.

lista=[]
soma=0
count=0
for i in range (5):
    n= int(input('numero: '))
    lista.append(n)
for i in lista:
    soma+=i
media= soma/len(lista)
for i in lista:
    if i > media:
        count+=1
print(media, count)