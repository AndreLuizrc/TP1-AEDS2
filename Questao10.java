import java.util.Scanner;

public class Questao10 {

    public static boolean palindromo(String texto){
        int tam_string = texto.length();
        return palindromo(texto, 0, tam_string-1);
    }
    //função de verificação de Palíndromo (recebe uma string como parametro e compara os elementos nas posições contrarias)
    public static boolean palindromo(String texto, int i, int j){
        int tam_string;
        boolean valid_poli;

        tam_string = texto.length();

        if(i == tam_string-1){ //0123
            valid_poli = true;
        } else if(texto.charAt(i) == texto.charAt(j)){ //Uso as minhas variaveis como indice para comparar se os vlaores nas posições contrarias são iguais
            valid_poli = palindromo(texto, i + 1, j - 1);
        } else {
            valid_poli = false;
        }
        
        return valid_poli;
            
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        int valid = 0;
        boolean retorno;

        do{
            string = scanner.nextLine();
            if(string.charAt(0) == 'F' && string.charAt(1) == 'I' && string.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                retorno = palindromo(string);
                if (retorno == true){
                        System.out.println("SIM");
                }else{
                        System.out.println("NAO");
                }
            }
        }while(valid != 1);

        scanner.close();
    }

 
}

