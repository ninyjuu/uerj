#include <stdio.h>

int tabuada(int numero) {
    for (int i=1; i<=10; i++) {
        printf("%dx%d= %d\n", numero, i, numero * i);
    }
    return 0;
}

int main() {
    int n;
    printf("insira um numero: ");
    scanf("%d", &n);
    tabuada(n);
    return 0;
}
