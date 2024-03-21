#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool Chamarpalindromo(char *);
bool palindromo(char *, int, int);

int main(){
    char string[400];
    int valid = 0;
    bool retorno;

    do{
        fgets(string,400,stdin); 
        if (string[0] == 'F' && string[1] == 'I' && string[2] == 'M'){
            valid = 1;
        }else{
            retorno = Chamarpalindromo(string);
            if (retorno == true){
                printf("SIM\n");
            }else{
                printf("NAO\n");
            }
        }
    }while(valid != 1);
}

bool Chamarpalindromo (char string[]){
    int tam_string = strlen(string);
    return palindromo(string, 0, tam_string-2 );
}

//função de verificação de Palíndromo (recebe uma string como parametro e compara se é um palindromo)
bool palindromo(char string[], int i, int j){
    int tam_string; 
    bool valid_poli;

    tam_string = strlen(string);

    if( i == tam_string-2){
        valid_poli = true;
    } else if(string[i] == string[j]){ //Uso as minhas variaveis como indice para comparar se os vlaores nas posições contrarias são iguais
        valid_poli = palindromo(string, i + 1, j - 1);
    } else{
        valid_poli = false;
    }

    return valid_poli;
}