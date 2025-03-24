#include <stdio.h>
int main(){
    int x;
    printf("1. inclusão\n");
    printf("2. alteração\n");
    printf("3. exclusão\n");
    printf("digite sua opção: \n");
    scanf("%d", &x);

    switch(x){
        case 1:
            printf("você escolheu inclusão\n");
            break;
        case 2:
            printf("você escolheu alteração\n");
            break;
        case 3:
            printf("você escolheu exclusão\n");
            break;
        default:
            printf("opção inválida");
    }

    return 0;
} 