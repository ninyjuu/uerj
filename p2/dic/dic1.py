dic={}
soma= 0
alunos= 0
while True:
    aluno= input('nome do aluno: ')
    if aluno.lower() == 'fim':
        break
    nota= float(input('nota: '))
    idade= int(input('idade: '))
    dic[aluno]= {'nota': nota, 'idade': idade}
    soma+= nota
    alunos+= 1
    
media= soma/ alunos

for aluno, info in dic.items():
    print(f'{aluno}: {info["nota"]}, {info["idade"]}')
print(f'média: {media:.2f}')