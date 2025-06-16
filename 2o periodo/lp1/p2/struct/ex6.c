#include <stdio.h>

typedef struct{
    char nome [50];
    int idade;
    float nota;
} Aluno;

Aluno *maisVelho (Aluno *vetor, int tamanho){
    Aluno *maior= &vetor[0];
    for (int i=0; i<tamanho; i++){
        if (vetor[i].idade > maior-> idade) maior= &vetor[i];
    }
    return maior;
}

int main() {
    int n;
    scanf("%d", &n);

    Aluno lista[n];

    for (int i = 0; i < n; i++) {
        scanf("%s", lista[i].nome);
        scanf("%d", &lista[i].idade);
        scanf("%f", &lista[i].nota);
    }

    Aluno *resultado = alunoMaisVelho(lista, n);

    if (resultado != NULL) {
        printf("Mais velho: %s, %d anos, nota %.2f\n", resultado->nome, resultado->idade, resultado->nota);
    }

    return 0;
}