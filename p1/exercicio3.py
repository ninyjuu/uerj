soma=0
n= int(input('inisira um número positivo: '))
for i in range (1,n):
if n%i==0:
    soma+=i
    if soma==n:
        print('é perfeito')
    else:
        print('nao é perfeito')