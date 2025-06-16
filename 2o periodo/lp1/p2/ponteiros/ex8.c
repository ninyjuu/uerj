#include <stdio.h>

void trocarValores (int *x, int *y){
    int temp= *x;
    *x= *y;
    *y= temp;
}

int main(){
    int x, y;
    scanf("%d %d", &x, &y);
    trocarValores(&x,&y);
    printf("%d %d", x, y); 
    return 0;
}
