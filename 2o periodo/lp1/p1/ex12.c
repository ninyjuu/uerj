/*Autor: Júlia Nicolao Bansemer.
Data: 06/04/2025.
Descrição: Uma lista de opções de programas para o usuário escolher.
Entrada: O número relacionado à opção.
Saída: O programa que será executado.
Restrições: Nenhuma.
*/

#include <stdio.h>

#define parimpar 1
#define posneg 2
#define maior 3
#define media2maiores 4
#define tipochar 5
#define sair 0

int main() {
    int opcao;

    printf("menu de opcoes:\n");
    printf("%d- par ou impar\n", parimpar);
    printf("%d- positivo ou negativo\n", posneg);
    printf("%d- maior de tres racionais\n", maior);
    printf("%d- media dos dois maiores\n", media2maiores);
    printf("%d- tipo de caractere\n", tipochar);
    printf("%d- sair\n", sair);
    printf("escolha uma opcao: ");
    scanf("%d", &opcao);

    switch(opcao) {
        case parimpar:
            printf("executando par ou impar...\n");
            break;
        case posneg:
            printf("executando positivo ou negativo...\n");
            break;
        case maior:
            printf("executando maior entre tres...\n");
            break;
        case media2maiores:
            printf("executando media dos dois maiores...\n");
            break;
        case tipochar:
            printf("executando tipo de caractere...\n");
            break;
        case sair:
            printf("saindo do programa.\n");
            break;
        default:
            printf("opção invalida.\n");
    }

    return 0;
}
