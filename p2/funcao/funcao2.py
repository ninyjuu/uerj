#funcao com dicionario e lista

def informacoes (nome):
    dic= {}
    notas= []
    idade= int(input('idade: '))
    while True:
        n= float(input('nota: '))
        if n<0:
            break
        notas.append(n)
    media= sum(notas)/len(notas)
    dic[nome]= {'idade': idade, 'notas': notas, 'media': media}

    for nome, info in dic.items():
        print(f'''nome: {nome}
idade: {info['idade']}
notas: {info['notas']}
notas: {info['media']:.2f}''')

n= input('nome: ')
informacoes(n)




        

