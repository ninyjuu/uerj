soma = 0
a= int(input('insira um número inteiro: '))
b= int(input('insira outro número inteiro: '))
if a < b:
    for i in range (a,b+1):
        cubo= i*i*i
        soma+=cubo
print (soma)