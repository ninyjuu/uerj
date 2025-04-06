/*Autor: Júlia Nicolao Bansemer.
Data: 06/04/2025.
Descrição: Verifica e retorna se é par ou ímpar; se é positivo ou negativo;
o maior deles; a média dos dois maiores; se é maiúsculo ou minúsculo.
Entrada: Um inteiro; um racional; três racinais; três racionais; um caractere.
Saída: -1 ou 1; 1 ou 0; o maior; a média; M ou m.
Restrições: Nenhuma.
*/

#include <stdio.h>
int main() {
    int n, parimpar;
    printf("digite um inteiro: ");
    scanf("%d", &n);
    parimpar= n%2==0? -1:1;
    printf("%d \n",parimpar);

    float h;
    int posneg;
    printf("digite um racional: ");
    scanf("%f", &h);
    posneg= h>0? 1:0;
    printf("%d \n",posneg);

    float x, y, z, big;
    printf("digite tres racionais: ");
    scanf("%f %f %f", &x, &y, &z);
    big= x>y && x>z? x : y>z? y:z;
    printf("o maior eh %.2f \n", big);

    float a, b, c, maior, smaior, media;
    printf("escreva tres racionais: ");
    scanf("%f %f %f", &a, &b, &c);
    if (a >= b && a >= c) {
        maior = a;
        smaior = (b > c)? b:c; }
        else if (b >= a && b >= c) {
        maior = b;
        smaior = (a > c)? a:c; }
        else {
        maior = c;
        smaior = (a > b)? a:b; }
    media = (maior + smaior) / 2;
    printf("a media entre os dois maiores eh %.2f\n", media);

    char p, tipo;
    printf("digite um caractere: ");
    scanf(" %c", &p);
    tipo= (p>='a' && p<='z')? 'm':
        (p>='A' && p<='Z')? 'M':'?';
    printf("%c\n", tipo);

return 0;
}