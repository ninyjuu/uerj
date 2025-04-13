#include <stdio.h>

int main() {
    int n, i, soma;

    for (n= 1; n<=1000; n++) {
        soma= 0;
        for (i= 1; i<n; i++) {
            if (n%i==0) {
                soma+= i;
            }
        }

        if (soma==n) {
            printf("%d\n", n);
        }
    }

    return 0;
}
