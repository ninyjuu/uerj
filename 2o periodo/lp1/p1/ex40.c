#include <stdio.h>

int potencia (int x, y){
    if (x>=y){
        return 0;
    }
    return x*potencia(x)
}

int main(){
    int num1, num2;
    printf("numeros: ");
    scanf("%d %d", &num1, &num2);
    printf("%d\n", potencia(num1, num2));
    return 0;
}