#include <stdio.h>

struct Produto{
    char nome[20];
    float preco;
    int qtd;
};

int main(){
    
    int qtdTotal;
    printf("quantidade total de produtos: ");
    scanf("%d", &qtdTotal);
    
    struct Produto p[qtdTotal];
    float valorEstoque= 0.0;
    int maiorValor;
    char maiorProduto[20];
    
    for (int i=0; i< qtdTotal; i++){
        maiorValor= p[0].preco*p[0].qtd;
        printf("nome, preco e quantidade do produto %d: ", i+1);
        scanf("%s %f %d", p[i].nome, &p[i].preco, &p[i].qtd);
        valorEstoque= p[i].preco*p[i].qtd;
        if (valorEstoque> maiorValor){
            maiorValor= valorEstoque;
            maiorProduto= p[i].nome;
        }
    }
    printf("%s\n", maiorProduto);
    printf("%d\n", qtdTotal);
    
    return 0;
}
