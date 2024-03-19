import java.util.Scanner;

//2 0 0 and(not(A) , not(B))
public class Questao5 {

    public static boolean AlgebraBoolean(String expressao){
        int tam_string = expressao.length();
        int num_entradas, n=0;
        String expressoes = "";
        boolean result;
        num_entradas = Character.getNumericValue(expressao.charAt(0));
        //System.out.println(expressao.charAt(0));
        int[] valores = new int[num_entradas];

        for(int i = 0, point = 0; i < num_entradas; i++){
            point += 2;
            valores[i] = Character.getNumericValue(expressao.charAt(point));
            System.out.println("Valores:" + valores[i]);
        }

        for(int i = tam_string-1; i >= 0; i--){
            if(expressao.charAt(i) == '('){
                for(int j = i; j < tam_string; j++){
                    if(expressao.charAt(j) == ')'){
                        expressoes = expressao.substring(i-1, j+1);
                        j = tam_string;
                    }
                }

                System.out.println(expressoes);

                if( expressoes.charAt(0) == 't'){
                    //result = not(expressoes);
                    System.out.println("not");
                } else if(expressoes.charAt(0) == 'd'){
                    //result = and(expressoes)
                    System.out.println("and");
                } else if(expressoes.charAt(0) == 'r'){
                    //result = or(expressoes)
                    System.out.println("or");
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
