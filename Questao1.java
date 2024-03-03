import java.util.Scanner;

public class Questao1 {
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

    //função de verificação de Palíndromo (recebe uma string como parametro e compara o)
    public static boolean palindromo(String texto){
        int tam_string, valid_poli = 0;

        tam_string = texto.length();

        for(int i = 0, j = tam_string - 1; j >= 0; i++, j--){ //crio duas variaveis auxiliares, uma começando em 0 e outra começando do tamanho da String
            if(texto.charAt(i) != texto.charAt(j)){ //Uso as minhas variaveis como indice para comparar se os vlaores nas posições contrarias são iguais
                valid_poli = 1;
            }
        }

        if(valid_poli == 0){
            return true;
        }else{
            return false;
        }
    }
}
