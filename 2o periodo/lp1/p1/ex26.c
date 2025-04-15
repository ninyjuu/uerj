#include <stdio.h>

int adicao(int x, int y){
    return x + y;
}
int sub(int x, int y){
    return x - y;
}
int mult(int x, int y){
    return x * y;
}
int divisao(int x, int y){
    if (y == 0) {
        printf("erro: divisao por zero!\n");
        return 0;
    }
    return x / y;
}

int main() {
    int a, b, operador, resultado;
    printf("digite dois numeros: ");
    scanf("%d %d", &a, &b);

    printf("\nescolha a operacao:\n");
    printf("1 - adicao\n");
    printf("2 - subtracao\n");
    printf("3 - multiplicacao\n");
    printf("4 - divisao\n");
    printf("digite sua escolha: ");
    scanf("%d", &operador);

    switch (operador) {
        case 1:
            resultado = adicao(a, b);
            printf("resultado: %d\n", resultado);
            break;
        case 2:
            resultado = sub(a, b);
            printf("resultado: %d\n", resultado);
            break;
        case 3:
            resultado = mult(a, b);
            printf("resultado: %d\n", resultado);
            break;
        case 4:
            resultado = divisao(a, b);
            printf("resultado: %d\n", resultado);
            break;
        default:
            printf("operacao invalida!\n");
    }

    return 0;
}
