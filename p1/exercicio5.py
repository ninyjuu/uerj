qtd_maior30= 0
soma= 0
media= 0
maior= 0

while True:
nome= input('insira o nome: ')
altura= float(input('insira a altura (<0 para parar): '))
if altura ‹ 0:
    break
idade= int(input(' insira a idade: ')
if idade > 30:
    qtd_maior30+=1
    soma+= altura
if altura > maior:
    maior = altura
if idade < 30:
    print('a maior altura é', maior) media- soma/qtd_maior30
    print('média das alturas:', media, 'e a maior altura é', maior)