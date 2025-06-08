#include <stdio.h>
#include <math.h>

struct Ponto {
    float x, y;
};

float calcularDistancia(struct Ponto *p1, struct Ponto *p2) {
    float dx, dy, distancia;

    dx= (p1->x)-(p2->x);
    dy= (p1->y)-(p2->y);
    distancia= sqrt(dx*dx+dy*dy);

    return distancia;
}

int main() {
    struct Ponto ponto1, ponto2;
    float distancia;

    printf("digite x e y do primeiro ponto: ");
    scanf("%f %f", &ponto1.x, &ponto1.y);
    printf("digite x e y do segundo ponto: ");
    scanf("%f %f", &ponto2.x, &ponto2.y);

    distancia= calcularDistancia(&ponto1, &ponto2);
    printf("%.2f\n", distancia);

    return 0;
}
