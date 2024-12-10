#calcule as seguintes estatísticas para o conjunto de notas de uma determinada turma:
#máximo, mínimo, média, desvio padrão, mediana e moda (primeira).
nota = [1.1, 7.5, 0.8, 1.8, 1.5, 1.9, 10.0, 10.0, 9.3, 10.0, 7.7, 0.6, 0.5, 8.7, 5.6, 7.0, 8.3, 7.0, 9.1, 7.4, 8.1, 7.0, 6.3, 0.6, 7.4, 2.8, 5.0, 1.4, 1.5, 0.5, 8.3, 7.0, 2.9, 7.6, 10.0, 3.3, 1.9, 5.1, 7.0]

aluno= len(nota)
k=nota[0]

#maior:
for n in nota:
    if n>k:
        k= n
print(k)

#menor:
for n in nota:
    if n<k:
        k=n
print(k)

#media:
media=sum(nota)/aluno
print(media)

#mediana:
nota.sort()
if aluno%2!=0:
    mediana= nota[aluno//2]
else:
    mediana= (nota[(aluno//2)-1]+nota[aluno//2])/2
print(mediana)

#moda:
moda=0
count=0
for i in nota:
    if nota.count(i) > count:
        count=nota.count(i)
        moda=i
print(moda)