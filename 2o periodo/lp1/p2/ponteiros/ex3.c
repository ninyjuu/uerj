#include <stdio.h>

void inverterVetor(int *v, int n) {
    int *inicio= v;
    int *fim = &v[n - 1];
    int temp;
    while(inicio<fim) {
        temp= *inicio;
        *inicio= *fim;
        *fim= temp;
        inicio++;
        fim--;
    }
}

int main() {
    int n;
    scanf("%d", &n);
    int v[n];
    for(int i=0; i<n; i++) scanf("%d", &v[i]);
    inverterVetor(v, n);
    for(int i=0; i<n; i++) printf("%d ", v[i]);
    return 0;
}
