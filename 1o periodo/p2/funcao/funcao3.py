def contagem(x):
    count=0
    vogais= ['a','e','i','o','u']
    for i in x:
        if i in vogais:
            count+=1
    return count
            
palavra= input('palavra: ')
print(contagem(palavra))