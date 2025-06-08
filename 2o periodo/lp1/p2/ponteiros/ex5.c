#include <stdio.h>

struct Ponto {
    float x, y;
};

void preencherPonto(struct Ponto *p, float x, float y) {
    p->x= x;
    p->y= y;
}

int main() {
    struct Ponto p;
    float x, y;

    printf("digite o valor de x: ");
    scanf("%f", &x);
    printf("digite o valor de y: ");
    scanf("%f", &y);
    preencherPonto(&p, x, y);

    printf("x= %.2f\n", p.x);
    printf("y= %.2f\n", p.y);

    return 0;
}
