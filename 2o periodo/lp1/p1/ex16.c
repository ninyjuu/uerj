#include <stdio.h>
int main(){
    int n, a, b, cont;
    printf("insira a quantidade de numeros na sequencia: ");
    scanf("%d %d %d", &n, &a, &b);

    cont= 0;

    for (int i=0; cont<n; i++){
        if (i%a==0 || i%b==0){
            printf("%d ", i);
            cont++;
        }
    }

    return 0;
}
