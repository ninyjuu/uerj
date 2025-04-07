n= int(input('insira a quantidade de n na sequencia: '))
a= int(input('insira o n multiplo: '))
b= int(input('insira o n multiplo: '))
count=i=0
while count<n:
    if i%a==0 or i%b==0:
        print(i)
        count+=1
    i+=1
    