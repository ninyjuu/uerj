ano= int(input('insira um ano: '))
if ano % 4 == 0:
    if ano % 400 == 0 and ano % 100 != 0:
        print('é bissexto')
    else:
        print('não é bissexto')
