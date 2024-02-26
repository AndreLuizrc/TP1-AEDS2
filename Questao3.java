import java.util.Scanner;

public class Questao3 {
    
    public static StringBuilder cripto(String texto){
        int tam_string = texto.length();
        StringBuilder string_modificada = new StringBuilder(texto); // crio uma string do tipo StringBuilder para poder receber o valor da minha string original e permitir este valor ser alterado
        char caracter, novoCarater;
        int valorASCII;

        //Neste looping eu faço a varredura de todos os caracteres da minha string de entrda
        for(int i = 0; i < tam_string; i++){
            caracter = texto.charAt(i); //pego o caracter da vez
            valorASCII = (int) caracter + 3; //passo este caracter para o valor inteiro dele referente a tabela ASCII e ja adiciono +3
            novoCarater = (char) valorASCII; //Transformo este valor ja modificado novamente para caracter
            string_modificada.setCharAt(i, novoCarater); //substitiu me valor original pelo valor modificado na minha String auxiliar 
        }
        
        return string_modificada;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto; 
        StringBuilder retorno;
        int valid = 0;

        do{
            texto = sc.nextLine();
            if(texto.equals("FIM")){ 
                valid = 1;
            }else{
                retorno = cripto(texto);
                System.out.println(retorno);
            }
        }while(valid != 1);

        sc.close();
    }
}
