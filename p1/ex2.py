nota50=0
nota20=0
nota10=0
nota5=0
nota1=0

caixa= int(input(' insira um valor: '))

nota50= caixa//50
caixa= caixa%50

nota20= caixa//20
caixa= caixa%20

nota10= caixa//10
caixa= caixa%10

nota5= caixa//5
caixa= caixa%5

nota1= caixa//1
caixa= caixa%1

print( 'notas de 50:', nota50, 'notas de 20:', nota20,
'notas de 10:', nota10, 'notas de 5:', nota5, 'notas de 1:', nota1)