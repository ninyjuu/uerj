#include <stdio.h>
#include <math.h>

int main(){
    double total, j, m;
    int n;

    printf("valor do bem: ");
    scanf("%lf", &total);
    printf("taxa de juros anual em %%: ");
    scanf("%lf", &j);
    j /= 100*12;
    printf("numero de meses: ");
    scanf("%d", &n);
    m= (total*j / (pow(1+j,n)-1));
    printf("investimento mensal: %.2f\n", m);
    getchar();
    return 0;
}
