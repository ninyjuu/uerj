#Peça ao usuário para inserir uma lista de números e um número
#específico. Escreva um programa queconte quantas vezes o número específico aparece na lista.

lista=[]
count=0
for i in range (0,5):
    n= int(input('insira um número: '))
    lista.append(n)
a= int(input('escolha um deles: '))
for i in range(len(lista)):
    if a == lista[i]:
        count+= 1
    
print(count)