#include <stdio.h>

struct Funcionario {
    char nome[30];
    float salario;
    int idade;
};

int main() {
    struct Funcionario f[5];

    for(int i=0; i< 5; i++)
        scanf("%s %f %d", f[i].nome, &f[i].salario, &f[i].idade);

    for(int i=0; i< 5; i++)
        if(f[i].idade> 40 && f[i].salario< 2000)
            printf("%s\n", f[i].nome);

    return 0;
}
