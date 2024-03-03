#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool palindromo(char *);

int main(){
    char string[200];
    int valid = 0;
    bool retorno;

    do{
        fgets(string,200,stdin); 
        if (string[0] == 'F' && string[1] == 'I' && string[2] == 'M'){
            valid = 1;
        }else{
            retorno = palindromo(string);
            if (retorno == true){
                printf("SIM\n");
            }else{
                printf("NAO\n");
            }
        }
    }while(valid != 1);
}

//função de verificação de Palíndromo (recebe uma string como parametro e compara se é um palindromo)
bool palindromo(char string[]){
    int tam_string, valid_poli = 0;

    tam_string = strlen(string);

    for(int i = 0, j = tam_string - 2; j >= 0; i++, j--){ //crio duas variaveis auxiliares, uma começando em 0 e outra começando do tamanho da String
        if(string[i] != string[j]){ //Uso as minhas variaveis como indice para comparar se os vlaores nas posições contrarias são iguais
            valid_poli = 1;
        }
    } 

    if(valid_poli == 0){
        return true;
    }else{
        return false;
    }
}