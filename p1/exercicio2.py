nota50=0
nota20=0
nota10=0
nota5=0
nota1=0

caixa= int(input(' insira um valor: '))

if caixa >= 50:
nota50+=caixa//50
resto= caixa%50

if resto >= 20：
nota20+=resto//20
resto= resto%20

if resto >= 10:
nota10+=resto//10
resto= resto%10

if resto >= 5:
nota5+=resto//5
resto= resto%5

if resto >= 1:
nota1+=resto//1
resto= resto%1

print( 'notas de 50:', nota50, 'notas de 20:', nota20,
'notas de 10:', nota10, 'notas de 5:', nota5, 'notas de 1:', nota1)