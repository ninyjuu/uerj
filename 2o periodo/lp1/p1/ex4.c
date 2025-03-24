#include <stdio.h>

int main(){
    int x,y,max;

    printf("entre com dois numeros: ");
    scanf("%d %d", &x, &y);
    max= (x>y)? x:y;
    printf("max= %d \n", max);

    return 0;
}