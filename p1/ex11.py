n= int(input('digite um número: '))
primos= 0
num= 2
while primos < n:
    primo= True
    for i in range(2, n):
        if n % i == 0:
            primo= False
            break
if primo:
    print(n)
    primos+= 1
    num+= 1