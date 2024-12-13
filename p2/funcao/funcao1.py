from math import sqrt
from math import floor

def primo(x):
    if x < 2 or x== 4:
        return 'nao e' 
    raiz= (sqrt(x))
    for i in range(2,floor(raiz)+1):
        if x%i== 0:
            return 'nao e'
    return 'primo'

n= int(input('numero: '))
print(primo(n))


