import java.util.Random;
import java.util.Scanner;

public class Questao4 {

    public static char[] Alter_String(String texto, Random gerador){
        //Variaveis com valores randomicos 
        char caracter1 = ((char) ('a' + (Math.abs(gerador.nextInt()) %26)));
        char caracter2 = ((char) ('a' + (Math.abs(gerador.nextInt()) %26)));
    
        int tam_string = texto.length();
        char[] vetor_string = new char[tam_string]; // vetor de char para receber minha string alterada

        for(int i = 0; i < tam_string; i++){
            if(texto.charAt(i) == caracter1){
                vetor_string[i] = caracter2;
            }else{
                vetor_string[i] = texto.charAt(i);
            }
        }

        return vetor_string;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto; 
        Random gerador = new Random();
        char[] retorno;
        int valid = 0;
        gerador.setSeed(4);

        do{
            texto = sc.nextLine();
            if(texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                retorno = Alter_String(texto, gerador);
                System.out.println(retorno);
            }
        }while(valid != 1);

        sc.close();
    }
}

