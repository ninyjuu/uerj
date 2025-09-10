notas= []
alunos= int(input("numero de alunos: "))
for i in range(alunos):
    nota= int(input(f"nota aluno {i+1}: "))
    notas.append(nota)
    print(notas)

def bubbleSort(lista):
    for i in range(len(lista)):
        for j in range(len(lista)-i-1):
            if lista[j] < lista[j+1]:
                lista[j], lista[j+1] = lista[j+ 1], lista[j]
    return lista

notas_ordenadas= bubbleSort(notas.copy())

alunos_mesma_posicao= 0
for i in range(alunos):
    if notas[i] == notas_ordenadas[i]:
        alunos_mesma_posicao += 1

print(alunos_mesma_posicao)