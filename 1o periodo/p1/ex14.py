frase= input('insira uma frase: ')
sep=frase.split(' ')
a= ""

for i in sep:
    a+= i[::-1] + ' '

print(a)