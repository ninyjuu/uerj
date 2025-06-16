#include <stdio.h>
#include <math.h>

typedef struct {
    float x, y;
} Ponto;

float calcularDistancia (Ponto p1, Ponto p2){
    float dx=p1.x - p2.x;
    float dy= p1.y - p2.y;
    float distancia= sqrt((dx*dx)+(dy*dy));
    return distancia;
}

int main(){
    Ponto a,b;
    scanf("%f %f", &a.x, &a.y);
    scanf("%f %f", &b.x, &b.y);
    printf("%f", calcularDistancia(a,b));
    return 0;
}