/*Autor: Júlia Nicolao Bansemer.
Data: 06/04/2025.
Descrição: Lê o símbolo digitado, e caso seja "@", exibirá o próximo símbolo.
Resposta: Foi exibida a mensagem padrão (default) além da letra A porque no
caso @ não tinha o "break".
*/

#include <stdio.h>
int main() {
    char simbolo;
    scanf("%c", &simbolo);

    switch(simbolo){
        case '!':
            printf("exclamacao.\n");
            break;
        case '?':
            printf("interrogacao.\n");
            break;
        case '@':
            printf("o prox simbolo eh %c.\n", simbolo+1);
            break;
        default:
            printf("simbolo qualquer.\n");
    }

return 0;
}
