#include <stdio.h>

int somadig(int n){
    if (n<10){
        return n;}
        return (n%10)+somadig(n/10);
}

int main(){
    int num;
    printf("numero: ");
    scanf("%d", &num);
    printf("%d\n", somadig(num));
    return 0;
}