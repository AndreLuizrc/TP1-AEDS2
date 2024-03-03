import java.util.Scanner;

//2 0 0 and(not(A) , not(B))
public class Questao5 {

    public boolean AlgebraBoolean(String expressao){
        int tam_string = expressao.length();
        int num_entradas;
        num_entradas = (int) expressao.charAt(0);
        int[] valores = new int[num_entradas];

        for(int i = 0; i <= num_entradas; i++){
            valores[i] = expressao.charAt(i+2);
        }

        for(int i = 0; i < tam_string; i++) {
            
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expressao;
        int valid = 0;
        boolean retorno; 

        do{
            expressao = sc.nextLine();
            if(expressao.charAt(0) == 'F' && expressao.charAt(1) == 'I' && expressao.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                retorno = true;
                if (retorno  == true){
                    System.out.println("SIM");
                }else {
                    System.out.println("NAO");

                }
            }
        }while(valid != 1);

        sc.close();
    }
}
