#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* ChamadaAlterString(char*);

char* AlterString(char*, int, char, char);

int main(){
    char string[200]; 
    char* retorno;
    int valid = 0;
    srand(4);

    do{
        fgets(string,200,stdin);
        if(string[0] == 'F' && string[1] == 'I' && string[2] == 'M'){
            valid = 1;
        } else {
            retorno = ChamadaAlterString(string);
            printf("%s", retorno);
        }
    }while( valid != 1);

}

//Função para chamar a 
char* ChamadaAlterString(char string[]){
    char caracter1, caracter2;
    caracter1 =  (char)(rand() % ('z' - 'a' + 1) + 'a');
    caracter2 =  (char)(rand() % ('z' - 'a' + 1) + 'a');
    return AlterString(string, 0, caracter1, caracter2);
}

char* AlterString(char string[], int i, char char1, char char2){
    int tam_string;
    //printf("%c\n", caracter1);

    tam_string = strlen(string);

    if( i >= tam_string){
        return string;
    } else {
        if( string[i] == char1){
            string[i] = char2;
        }

        return AlterString(string, i+1, char1, char2);
    }
}