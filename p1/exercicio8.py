count_pos= 0
count_neg= 0

while True:
    n= int(input('insira um número diferente de 0: '))
    if n > 0:
        count_pos+= 1
    elif n < 0:
        count_neg+= 1
    else:
        break

print('n postivos:', count_pos, 'n negativos:', count_neg)
