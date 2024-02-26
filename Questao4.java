import java.util.Random;
import java.util.Scanner;

public class Questao4 {

    public static StringBuilder Alter_String(String texto, Random gerador){
        char caracter1 = ((char) ('a' + (Math.abs(gerador.nextInt()) %26)));
        char caracter2 = ((char) ('a' + (Math.abs(gerador.nextInt()) %26)));
        //System.out.println(caracter1);
        //System.out.println(caracter2);
        StringBuilder String_nova = new StringBuilder(texto);
        int tam_string = texto.length();

        for(int i = 0; i < tam_string; i++){
            if(texto.charAt(i) == caracter1){
                String_nova.setCharAt(i, caracter2);
            }
        }

        return String_nova;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto; 
        Random gerador = new Random();
        StringBuilder retorno;
        int valid = 0;
        gerador.setSeed(4);

        do{
            texto = sc.nextLine();
            if(texto.equals("FIM")){ 
                valid = 1;
            }else{
                retorno = Alter_String(texto, gerador);
                System.out.println(retorno);
            }
        }while(valid != 1);

        sc.close();
    }
}
