dic= {}

while True:
    nome= input('nome: ')
    nasc= int(input('nascimento: '))
    ctps= int(input('carteira trabalho (0 nao tem): '))
    if ctps == 0:
        print('sem carteira')
        idade= 2024-nasc
        dic[nome]= {'idade': idade,}
    else:
        ano= int(input('ano contratacao: '))
        sal= float(input('salario: '))
        idade= 2024-nasc
        dic[nome]= {'idade': idade,'carteira de trabalho': ctps, 'ano entrada': ano, 'salario': sal}
    break
    
for nome, info in dic.items():
    if 'carteira de trabalho' not in info:
        print(nome,info['idade'])
    else:
        print(nome,info['idade'], info['carteira de trabalho'], info['ano entrada'], info['salario'])

