#include <stdio.h>

typedef struct {
    int idade;
    char nome[20];
} Pessoa;

Pessoa* maisVelha(Pessoa *a, Pessoa *b) {
    if(a->idade > b->idade) return a;
    if(b->idade > a->idade) return b;
    return a;
}

int main() {
    Pessoa a, b;
    scanf(" %s", a.nome);
    scanf("%d", &a.idade);
    scanf(" %s", b.nome);
    scanf("%d", &b.idade);
    Pessoa *r= maisVelha(&a, &b);
    printf("%s %d\n", r->nome, r->idade);
    return 0;
}
