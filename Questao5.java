import java.util.Scanner;

//2 0 0 and(not(A) , not(B))
public class Questao5 {

    public static boolean AlgebraBoolean(String expressao){
        int tam_string = expressao.length();
        int num_entradas, n=0;
        String expressoes;
        boolean result;
        //num_entradas = (int)expressao.charAt(0);
        //System.out.println(expressao.charAt(0));
        /*int[] valores = new int[num_entradas];

        for(int i = 0; i <= num_entradas; i++){
            valores[i] = expressao.charAt(i+2);
            System.out.println(valores[i]);
        }*/
        for(int i = tam_string; i >= 0; i--){
            if(expressao.charAt(i) == '('){
                for(int j = i; j < tam_string; j++){
                    if(expressao.charAt(j) == ')'){
                        expressoes = expressao.substring(i, j);
                        j = tam_string;
                    }
                }

                if( expressao.charAt(i-1) == 't'){
                    result = not(expressoes);
                } else if(expressao.charAt(i-1) == 'd'){
                    result = and(expressoes)
                } else if(expressao.charAt(i-1) == 'r'){
                    result = or(expressoes)
                }
            }
        }

        return true;
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
                retorno = AlgebraBoolean(expressao);
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
