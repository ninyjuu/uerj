/*Autor: Júlia Nicolao Bansemer.
Data: 06/04/2025.
Descrição: Verifica se o usuário foi arpovado ou não.
Entrada: Uma nota
Saída: Aprovado ou reprovado.
Restrições: Nenhuma.
*/

#include <stdio.h>
int main() {
    const float limite= 5.0;
    float nota1, nota2, media;

    printf("digite a primeira nota: ");
    scanf("%f", &nota1);

    printf("digite a segunda nota: ");
    scanf("%f", &nota2);

    media= (nota1 + nota2) / 2;

    if (media>=limite) {
        printf("aprovado\n");
    } else {
        printf("reprovado\n");
    }

    return 0;
}
