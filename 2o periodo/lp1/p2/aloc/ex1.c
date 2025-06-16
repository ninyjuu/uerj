#include <stdio.h>
#include <stdlib.h>

int main() {
    int *v = (int*) calloc(3, sizeof(int)); // aloca 3 ints zerados
    for (int i = 0; i < 3; i++) {
        v[i] = i + 1;
        printf("%d ", v[i]);
    }
    printf("\n");

    v = (int*) realloc(v, 5 * sizeof(int)); // aumenta para 5 ints
    for (int i = 3; i < 5; i++) {
        v[i] = i + 1;
    }
    for (int i = 0; i < 5; i++) {
        printf("%d ", v[i]);
    }
    printf("\n");

    free(v); // libera a memória no fim

    return 0;
}
