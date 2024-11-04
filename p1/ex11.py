n= int(input('digite um número: '))
count= 0
num= 2
while count < n:
    primo= True
    for i in range(2, num):
        if num % i == 0:
            primo= False
            break
if primo:
    print(num)
    count+= 1
    num+= 1