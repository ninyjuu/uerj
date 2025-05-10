vetor= [4,6,3,8,1,5]
for i in range (0, len(vetor)-1):
    menor= i
    for j in range (i+1, len(vetor)):
        if vetor[j]< vetor[menor]:
            menor= j
    vetor[i], vetor[menor] = vetor[menor], vetor[i]
print(vetor)