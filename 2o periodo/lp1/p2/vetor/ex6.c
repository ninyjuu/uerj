#include <stdio.h>

int main() {
    char p[21];
    int i, tam= 0;
    scanf("%s", p);

    while(p[tam]!= '\0')
        tam++;

    for(i= 0; i< tam/2; i++)
        if(p[i]!= p[tam - 1 - i]) {
            printf("nao eh palindromo\n");
            return 0;
        }
    printf("palindromo\n");
    return 0;
}
