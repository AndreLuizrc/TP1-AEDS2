import java.util.Scanner;

public class Questao3 {
    
    public static char[] cripto(String texto){
        int tam_string = texto.length();
        char[] vetor_string = new char[tam_string];
        char caracter, novoCarater;
        int valorASCII;

        for(int i = 0; i < tam_string; i++){
            caracter = texto.charAt(i); //pego o caracter da vez
            valorASCII = (int) caracter; //passo este caracter para o valor inteiro dele referente a tabela ASCII
            if (valorASCII >= 1 && valorASCII <= 127) { //verifica se o caracterere é uma letra
                valorASCII += 3;
            }
            novoCarater = (char) valorASCII; //Transformo este valor ja modificado novamente para caracter
            vetor_string[i] = novoCarater;
        }
        
        return vetor_string;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto; 
        char[] retorno;
        int valid = 0;

        do{
            texto = sc.nextLine();
            if(texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                retorno = cripto(texto);
                System.out.println(retorno);
            }
        }while(valid != 1);

        sc.close();
    }
}
