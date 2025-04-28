#include <stdio.h>

int soma(int n){
    if (n <= 0) return 0;
    return n + soma(n - 1);
}

int main(){
    int num;
    printf("numero: ");
    scanf("%d", &num);
    printf("%d\n", soma(num));
    return 0;
}