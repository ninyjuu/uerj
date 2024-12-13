dic= {}
aluno= ''
count= 0
soma= 0

while aluno != 'fim':
    aluno= input('nome do aluno: ')
    if aluno == 'fim':
        break
    nota= float(input('nota do aluno: '))
    soma+= nota
    count+= 1
    media= soma/count
    dic[aluno]= nota

print(dic)
print(media)
