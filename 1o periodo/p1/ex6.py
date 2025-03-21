id_len= 0
id_rap= 0
mais_rap= 0
mais_len= 0

id1= int(input('identificação carro 1: '))
v1= int(input('velocidade carro 1: '))
if v1 > mais_rap:
    mais_rap= v1
    id_rap= id1
if v1 > mais_len:
    mais_len= v1
    id_len= id1

id2= int(input('identificação carro 2: '))
v2= int(input('velocidade carro 2: '))
if v2 > mais_rap:
    mais_rap= v2
    id_rap= id2
if v2 < mais_len:
    mais_len= v2
    id_len= id2

id3= int(input('identificação carro 3: '))
v3= int(input('velocidade carro 3: '))
if v3 > mais_rap:
    mais_rap= v3
    id_rap= id3
if v3 < mais_len:
    mais_len= v3
    id_len= id3

print('mais rápido:', id_rap, mais_rap, 'mais lento:', id_len, mais_len)





