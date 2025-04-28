#include <stdio.h>

int soma (int n){
    int sum=0;
    for (int i; i<=n; i++){
        sum+=i;
    }
    return sum;
}

int main(){
    int num;
    printf("numero: ");
    scanf("%d", &num);
    printf("%d\n", soma(num));
    return 0;
}