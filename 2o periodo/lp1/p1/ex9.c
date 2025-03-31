/*
Autor: Júlia Nicolao Bansemer.
Data: 30/03/2025.
Descrição: Escrever um programa que leia as coordenadas de um ponto (x,y) no
plano cartesiano e fdetermine em qual quadrante ele está.
Entrada: Dois números.
Saída: Número do quadrante.
Restrições: Nenhuma.
*/

#include <stdio.h>
int main() {
    float x, y;

    printf("Digite as coordenadas x e y: ");
    scanf("%f %f", &x, &y);

    if (x == 0 && y == 0) {
        printf("O ponto está na origem.\n");
    } else if (x == 0) {
        printf("O ponto está sobre o eixo Y.\n");
    } else if (y == 0) {
        printf("O ponto está sobre o eixo X.\n");
    } else if (x > 0 && y > 0) {
        printf("O ponto está no quadrante 1.\n");
    } else if (x < 0 && y > 0) {
        printf("O ponto está no quadrante 2.\n");
    } else if (x < 0 && y < 0) {
        printf("O ponto está no quadrante 3.\n");
    } else {
        printf("O ponto está no quadrante 4.\n");
    }

    return 0;
}
