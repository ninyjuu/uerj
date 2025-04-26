/* Autor: Júlia Nicolao Bansemer.
Data: 25/04/2025.
Descrição: Inverte os dígitos de um número inteiro.
Entrada: Um número inteiro.
Saída: O número invertido.
Restrições: Nenhuma.
*/


#include <stdio.h>

int inverso(int numero) {
    int invertido= 0;

    int original= numero;
    if (numero<0)
        numero= -numero;

    while (numero!=0) {
        int digito= numero%10;
        invertido= invertido*10+ digito;
        numero= numero/10;
    }

    if (original<0)
        return -invertido;
    else
        return invertido;
}
