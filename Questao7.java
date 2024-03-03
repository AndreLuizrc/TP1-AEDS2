import java.net.URL;
import java.util.Scanner;

public class Questao7 {
    
    /*public static String getUrl(String endereco){
        
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome, url; 
        char[] retorno;
        int valid = 0;

        do{
            nome = sc.nextLine();
            url = sc.nextLine();
            if(nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                //retorno = cripto(texto);
                System.out.println(retorno);
            }
        }while(valid != 1);

        sc.close();
    }
}
