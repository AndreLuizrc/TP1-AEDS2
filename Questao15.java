import java.util.Scanner;

public class Questao15 {
    
    public static boolean vogais(String texto){
        return vogais(texto, 0);
    }

    public static boolean vogais(String texto, int i){
        int tam_string = texto.length();
        boolean valid;

        if(i >= tam_string-1){
            valid = true;
        } else if (texto.charAt(i) != 'a' && texto.charAt(i) != 'e' && texto.charAt(i) != 'i' && texto.charAt(i) != 'o' && texto.charAt(i) != 'u' // verifico se é uma vogal ou não
            && texto.charAt(i) != 'A' && texto.charAt(i) != 'E' && texto.charAt(i) != 'I' && texto.charAt(i) != 'O' && texto.charAt(i) != 'U'){
            valid = false;
        } else {
            valid = vogais(texto, i + 1);
        }


        return valid;
    }

    public static boolean consoantes (String texto){
        return consoantes(texto, 0);
    }

    public static boolean consoantes(String texto, int i){
        int tam_string = texto.length();
        boolean valid;
        int valor_ASCII;

        
        if(i >= tam_string){
            valid = true;
        }else{
            valor_ASCII = (int) texto.charAt(i);
            if((valor_ASCII >= 65 && valor_ASCII <= 90) || (valor_ASCII >= 97 && valor_ASCII <= 122)){ //Pego o valor AISCC do caracter para analisar se ele é uma letra
                if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u' // verifico se ele é um consoante ou uma vogal
                || texto.charAt(i) == 'A' || texto.charAt(i) == 'E' || texto.charAt(i) == 'I' || texto.charAt(i) == 'O' || texto.charAt(i) == 'U'){
                   valid = false;
                } else{
                    valid = consoantes(texto, i+1);
                }
            } else{
                valid = false;
            }
        }

        

        return valid;
    }

    public static boolean inteiro(String texto){
        return inteiro(texto, 0);
    }

    public static boolean inteiro(String texto, int i){
        int tam_string = texto.length();
        boolean valid;
        int valor_ASCII;

        
        if(i >= tam_string){
            valid = true;
        }else{
            valor_ASCII = (int) texto.charAt(i);
            if( valor_ASCII < 48 || valor_ASCII > 57){ // verifo o valor ASCII para verificar se representa um numero
                valid = false;
            } else{
                valid = inteiro(texto, i+1);
            }
        }
        
        return valid;
    }

    public static boolean real(String texto){
        return real(texto, 0, 0);
    }

    public static boolean real(String texto, int i, int cont_div){
        int tam_string = texto.length();
        boolean valid;
        int valor_ASCII;
         
        
        if(i >= tam_string){
            valid = true;
        }else{
            valor_ASCII = (int) texto.charAt(i);
            if( valor_ASCII < 48 || valor_ASCII > 57){ // verifico se é um numero
                if (valor_ASCII == 44 || valor_ASCII == 46){ // caso o caracter não seja um número verifo se é "." ou ","
                    valid = real(texto, i+1, cont_div+1);
                } else{
                    valid = false;
                }
            } else {
                valid = real(texto, i+1 , cont_div);
            }
        }
        

        if ( cont_div > 1) { // retorno false se a string tiver mais de um "." ou ","
            valid = false;
        }

        return valid;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto, result1, result2, result3, result4; 
        boolean retorno1, retorno2, retorno3, retorno4;
        int valid = 0;

        do{
            texto = sc.nextLine();
            if(texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                retorno1 = vogais(texto);
                retorno2 = consoantes(texto);
                retorno3 = inteiro(texto);
                retorno4 = real(texto);
                if (retorno1  == true){
                    result1 = "SIM";
                }else {
                    result1 = "NAO";
                }

                if (retorno2  == true){
                    result2 = "SIM";
                }else {
                    result2 = "NAO";
                }

                if (retorno3  == true){
                    result3 = "SIM";
                }else {
                    result3 = "NAO";
                }

                if (retorno4  == true){
                    result4 = "SIM";
                }else {
                    result4 = "NAO";
                }

                System.out.println(result1 + " " + result2 + " " + result3 + " " + result4);

            }
        }while(valid != 1);

        sc.close();
    }
}

