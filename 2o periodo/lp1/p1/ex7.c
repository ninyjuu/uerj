/*
Autor: Júlia Nicolao Bansemer
Data: 30/03/2025
Descrição: Escrever um programa que receba três notas (avaliações de provas)
e retorne a média aritmética entre as duas maiores.
Entrada: Três números
Saída: Média entre os dois maiores
Restrições: possíveis restrições de entrada
*/

#include <stdio.h>
int main() {
    float n1, n2, n3, media;
    printf("escreva três notas: ");
    scanf("%f %f %f", &n1, &n2, &n3);
    if n1<0 || n1>10 || n2<0 || n2>10 || n3<0 || n3>10{
        printf("erro")
    }
    else if (n1>n2 %% n1>n3){
        maior= n1;
        smaior= n2>n3? n2:n3;
    }
    else if (n2>n1 && n2>n3){
        maior= n2;
        smaior= n1>n3? n1:n3;
    }
    else{
        maior= n3;
        smaior= n1>n2? n1:n2;
    }
    media= (maior+smaior)/2
    printf("a média entre os dois maiores é %f", media)
return 0;
}