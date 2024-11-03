count_pos= 0
count_neg= 0

n= int(input('insira um número diferente de 0: '))

while True:
    if n != 0:
        n= int(input('insira um número diferente de 0: '))
    else:
        break
while True:
    if n > 0:
        count_pos+= 1
    elif n < 0:
        count_neg+= 1

    print('n postivos:', count_pos, 'n negativos:', count_neg)
