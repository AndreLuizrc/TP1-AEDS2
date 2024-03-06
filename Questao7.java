import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Questao7 {
    
    public static Scanner sc = new Scanner(System.in);

    //Função para ler a URL, iniciar a conexão com o site e retornar o conteudo HTML do mesmo
    public static String getUrl(String endereco) {
        URI uri;
        URL url;
        InputStream is;
        BufferedReader br;
        String text = " ", line;
        try{
            uri = new URI(endereco); //inicialização da URI passando o endereço como paramentro
            url = uri.toURL(); // trasnformação da URI para URL
            is = url.openStream(); //Abertura de conesão com o site
            br = new BufferedReader(new InputStreamReader(is)); // Buffer para ler o conteudo do site

            while((line = br.readLine()) != null){
                text += line;
            }
        } catch(MalformedURLException e){ //catchs para capturar as excessões do código de comunicação
            e.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }

        return text;
 
    }

    //função para contar vogais presentes no texto da url passada
    public static int[] contVogais(String text){
        int[] vetor_cont = new int[22];

        int tam_string = text.length();

        for(int i = 0; i < tam_string; i++){
            if( text.charAt(i) == 'a' ){
                vetor_cont[0] += 1;
            } else if( text.charAt(i) == 'e'){
                vetor_cont[1] += 1;
            } else if( text.charAt(i) == 'i'){
                vetor_cont[2] += 1;
            } else if(text.charAt(i) == 'o' ){
                vetor_cont[3] += 1;
            } else if(text.charAt(i) == 'u'){
                vetor_cont[4] += 1;
            } else if(text.charAt(i) == '\u00E1'){
                vetor_cont[5] += 1;
            } else if(text.charAt(i) == '\u00E9'){
                vetor_cont[6] += 1;
            } else if(text.charAt(i) == '\u00ED'){
                vetor_cont[7] += 1;
            } else if(text.charAt(i) == '\u00F3'){
                vetor_cont[8] += 1;
            } else if(text.charAt(i) == '\u00FA'){
                vetor_cont[9] += 1;
            } else if(text.charAt(i) == '\u00E0'){
                vetor_cont[10] += 1;
            } else if(text.charAt(i) == '\u00E8'){
                vetor_cont[11] += 1;
            } else if(text.charAt(i) == '\u00EC'){
                vetor_cont[12] += 1;
            } else if(text.charAt(i) == '\u00F2'){
                vetor_cont[13] += 1;
            } else if(text.charAt(i) == '\u00F9'){
                vetor_cont[14] += 1;
            } else if(text.charAt(i) == '\u00E3'){
                vetor_cont[15] += 1;
            } else if(text.charAt(i) == '\u00F5'){
                vetor_cont[16] += 1;
            } else if(text.charAt(i) == '\u00E2'){
                vetor_cont[17] += 1;
            } else if(text.charAt(i) == '\u00EA'){
                vetor_cont[18] += 1;
            } else if(text.charAt(i) == '\u00EE'){
                vetor_cont[19] += 1;
            } else if(text.charAt(i) == '\u00F4'){
                vetor_cont[20] += 1;
            } else if(text.charAt(i) == '\u00FB'){
                vetor_cont[21] += 1;
            }
            
        }

        return vetor_cont;
    }

    //Função para contar consoantes no HTML da URL
    public static int contConsoantes(String text){
        int cont_consoantes = 0;
        int tam_string = text.length();
        int valorAISCC;

        for(int i = 0; i < tam_string; i++) {
            valorAISCC = (int) text.charAt(i);
            if((valorAISCC >= 97 && valorAISCC <= 122)){ //Pego o valor AISCC do caracter para analisar se ele é uma letra OBS: A saida do vdd esta considerando apenas a letras minusculas por isso tirei a verificação das maisculas
                if (text.charAt(i) != 'a' && text.charAt(i) != 'e' && text.charAt(i) != 'i' && text.charAt(i) != 'o' && text.charAt(i) != 'u' // verifico se ele é um consoante ou uma vogal
                && text.charAt(i) != 'A' && text.charAt(i) != 'E' && text.charAt(i) != 'I' && text.charAt(i) != 'O' && text.charAt(i) != 'U'){
                   cont_consoantes += 1;
               } 
            }
        }

        return cont_consoantes;
    }

    //Função para contar tags <br> no HTML da URL
    public static int contBr(String text){
        int tam_string = text.length();
        int cont_br = 0;

        for(int i = 0; i < tam_string; i++){
            if (text.charAt(i) == '<' && text.charAt(i+1) == 'b' && text.charAt(i+2) == 'r' && text.charAt(i+3) == '>' ) {
                cont_br += 1;
            }
        }

        return cont_br;
    }

    //Funão para contar tags <table> no HTML da URL
    public static int contTable(String text){
        int tam_string = text.length();
        int cont_Table = 0;

        for(int i = 0; i < tam_string; i++){
            if (text.charAt(i) == '<' && text.charAt(i+1) == 't' && text.charAt(i+2) == 'a' && text.charAt(i+3) == 'b' 
            && text.charAt(i+4) == 'l' && text.charAt(i+5) == 'e' && text.charAt(i+6) == '>' ) {
                cont_Table += 1;
            }
        }

        return cont_Table;
    }
    public static void main(String[] args) {
        String name, url = ""; 
        String text;
        int valid = 0, consoantes, br_tags, table_tags;
        int[] vogais = new int[22];
        String result;
        do{
            name = sc.nextLine();
            if(sc.hasNextLine()){
                url = sc.nextLine();
            }
            
            if(name.charAt(0) == 'F' && name.charAt(1) == 'I' && name.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                text = getUrl(url);
                vogais = contVogais(text);
                consoantes = contConsoantes(text);
                br_tags = contBr(text);
                table_tags = contTable(text);
                consoantes = consoantes - (table_tags * 3) - (br_tags * 2);
                result = "a(" + vogais[0] + ") e(" + vogais[1] + ") i(" + vogais[2] + ") o(" + vogais[3] + ") u(" + vogais[4] + ") \u00E1(" + vogais[5] + ") \u00E9(" + vogais[6] + ") \u00ED(" + vogais[7] + 
                ") \u00F3(" + vogais[8] + ") \u00FA(" + vogais[9] + ") \u00E0(" + vogais[10] + ") \u00E8(" + vogais[11] + ") \u00EC(" + vogais[12] + ") \u00F2(" + vogais[13] + ") \u00F9(" + vogais[14] + 
                ") \u00E3(" + vogais[15] + ") \u00F5(" + vogais[16] + ") \u00E2(" + vogais[17] + ") \u00EA(" + vogais[18] + ") \u00EE(" + vogais[19] + ") \u00F4(" + vogais[20] + ") \u00FB(" + vogais[21] + 
                ") consoantes(" + consoantes + ") <br>(" + br_tags + ") <table>(" + table_tags + ") " + name;
                
                System.out.println(result);
            }
        }while(valid != 1);

        sc.close();
    }
}
