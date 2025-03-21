from random import randint

continua= 's'
while continua == 's':

    n= int(input('insira um número de 0  100: '))
    pc= randint(0,100)

    if n == pc:
        print('você acertou!')
    while n != pc:
        if n > pc:
            n= int(input('tente mais baixo: '))
        elif n < pc:
            n= int(input('tente mais alto: '))
    if n == pc:
        print('você acertou!')    
    continua= input('continua? ')