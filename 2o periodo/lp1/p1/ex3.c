#include <stdio.h>

int main (){
    int num, num2;

    printf("insira dois numeros inteiros separdos por espaço: ");
    scanf("%d %d", &num, &num2);
    if (num==num2){
        printf("eles sao iguais\n");
    }
    else if (num>num2){
        printf("o primeiro (%d) é maior\n", num);
    }
    else{
        printf("o segundo (%d) eh maior\n", num2);
    }
    return 0;
}