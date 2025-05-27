#include <stdio.h>

struct Produto {
    char nome[30];
    float preco;
};

int main() {
    struct Produto p[10];;

    for(int i= 0; i< 10; i++) {
        scanf("%s %f", p[i].nome, &p[i].preco);
        printf("%s- R$ %.2f\n", p[i].nome, p[i].preco);
        if(p[i].preco< 20)
            printf("%s: menor que 20\n", p[i].nome);
        else if(p[i].preco<= 100)
            printf("%s: entre 20 e 100\n", p[i].nome);
        else
            printf("%s: maior que 100\n", p[i].nome);
    }

    return 0;
}
