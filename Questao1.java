import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        int valid = 0;
        boolean retorno;

        do{
            string = scanner.nextLine();
            if(string.equals("FIM")){ 
                valid = 1;
            }else{
                retorno = palindromo(string);
                if (retorno == true){
                        System.out.println("SIM");
                }else{
                        System.out.println("NÃO");
                }
            }
        }while(valid != 1);

        scanner.close();
    }

    //função de verificação de Palíndromo (recebe uma string como parametro e compara o)
    public static boolean palindromo(String texto){
        int tam_string, valid_poli = 0;

        tam_string = texto.length();

        for(int i = 0, j = tam_string - 1; j >= 0; i++, j--){
            if(texto.charAt(i) != texto.charAt(j)){
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
