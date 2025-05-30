#include <stdio.h>

int dobraValor(int *x){
    *x*= 2;
    return *x;
}

int main(){
    int a;
    printf("valor x: ");
    scanf("%d", &a);
    printf("%d\n", dobraValor(&a));
    return 0;
}