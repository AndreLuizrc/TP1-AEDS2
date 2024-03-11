#include <stdio.h>

void PreencherArquivo(int);

void LerArquivo();

int main(){
    int num;

    scanf("%d", &num);

    PreencherArquivo(num);
    LerArquivo();
    
}

void PreencherArquivo(int num){
    float numFloat;
    FILE *arquivo = fopen("teste.txt", "w");

    for(int i = 0; i < num; i++){
        scanf("%f", &numFloat);
        fprintf(arquivo,"%f\n",numFloat);
    }

    fclose(arquivo);
}

void LerArquivo(){
    FILE *arquivo = fopen("teste.txt","r");

    float numFloat;
    long posicao;
    //int aux = num;
    fseek(arquivo,0,SEEK_END);
    posicao = ftell(arquivo) - 2;
    while(posicao >= 0){
        //printf("position variavel: %ld\n",posicao);
        //printf("posicao ponteiro %ld\n",ftell(arquivo));
        fseek(arquivo,--posicao,SEEK_SET);

        if(fgetc(arquivo) == '\n'){
            fscanf(arquivo,"%f",&numFloat);
            printf("%g\n", numFloat);

            posicao--;
        }

    }

    fseek(arquivo,0,SEEK_SET);
    fscanf(arquivo,"%f",&numFloat);
    printf("%g\n", numFloat);

    fclose(arquivo);

}
