#include <stdio.h>

int digitos(int n){
    int cont= 0;
    for (int i; i <= n; i++){
        n/=10;
        cont+=1;
    }
    return cont;
}

int main(){
    int num;
    printf("numero: ");
    scanf("%d", &num);
    printf("%d\n", digitos(num));
    return 0;
}