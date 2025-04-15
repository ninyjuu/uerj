#include <stdio.h>

int primo(int a) {
    if (a < 2) {
        return 0;
    } else {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return 0;
            }
        }
    }
    return 1;
}

int main() {
    int b, c;
    printf("insira dois numeros: ");
    scanf("%d %d", &b, &c);
    printf("numeros primos entre %d e %d:\n", b, c);

    if (b > c) {
        int temp = b;
        b = c;
        c = temp;
    }
    for (int i = b; i <= c; i++) {
        if (primo(i)) {
            printf("%d\n", i);
        }
    }
    return 0;
}
