#Remover Duplicatas: Peça ao usuário para inserir uma lista de números com
#possíveis elementos duplicados. O programa deve remover todas as duplicatas e exibir a lista sem elas

lista=[]
for i in range(5):
    n= int(input('numero: '))
    lista.append(n)
lista2=[]
for j in lista:
    if j not in lista2:
        lista2.append(j)

print(lista2)