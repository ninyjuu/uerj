try:
    t= int(input())
except ValueError:
    t= 0

if 1<=t<=1000:
    for i in range(t):
        try:
            entrada_dimensoes=input().split()
   
            if len(entrada_dimensoes)!=3:
                print("quantidade errada de dimensoes")
                continue
    
            altura= int(entrada_dimensoes[0])
            largura= int(entrada_dimensoes[1])
            comprimento= int(entrada_dimensoes[2])
   
            area_bases= largura*comprimento*2
            area_paredes_laterais= largura*altura*2
            area_paredes_restantes= comprimento*altura*2
            area_total= area_bases+area_paredes_laterais+area_paredes_restantes
   
            print(area_total)
        
        except:
            pass