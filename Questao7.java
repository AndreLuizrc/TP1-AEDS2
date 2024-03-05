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

    public static String getUrl(String endereco) {
        URI uri;
        URL url;
        InputStream is;
        BufferedReader br;
        String text = " ", line;
        try{
            uri = new URI(endereco);
            url = uri.toURL();
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while((line = br.readLine()) != null){
                text += line;
            }
        } catch(MalformedURLException e){
            e.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }

        //System.out.println(url);

        return text;
 
    }

    //função para contar vogais presentes no texto da url passada
    public static int[] contVogais(String text){
        int[] vetor_cont = new int[21];

        int tam_string = text.length();

        for(int i = 0; i < tam_string; i++){
            if( text.charAt(i) == 'a' || text.charAt(i) == 'A'){
                vetor_cont[0] += 1;
            } else if( text.charAt(i) == 'e' || text.charAt(i) == 'E') {
                vetor_cont[1] += 1;
            } else if( text.charAt(i) == 'i' || text.charAt(i) == 'I'){
                vetor_cont[2] += 1;
            } else if(text.charAt(i) == 'o' || text.charAt(i) == 'O'){
                vetor_cont[3] += 1;
            } else if(text.charAt(i) == 'u' || text.charAt(i) == 'U'){
                vetor_cont[4] += 1;
            } else if(text.charAt(i) == 'á' || text.charAt(i) == 'Á'){
                vetor_cont[5] += 1;
            } else if(text.charAt(i) == 'é' || text.charAt(i) == 'É'){
                vetor_cont[6] += 1;
            } else if(text.charAt(i) == 'í' || text.charAt(i) == 'Í'){
                vetor_cont[7] += 1;
            } else if(text.charAt(i) == 'ó' || text.charAt(i) == 'Ó'){
                vetor_cont[8] += 1;
            } else if(text.charAt(i) == 'ú' || text.charAt(i) == 'Ú'){
                vetor_cont[9] += 1;
            } else if(text.charAt(i) == 'à' || text.charAt(i) == 'À'){
                vetor_cont[10] += 1;
            } else if(text.charAt(i) == 'è' || text.charAt(i) == 'È'){
                vetor_cont[11] += 1;
            } else if(text.charAt(i) == 'ì' || text.charAt(i) == 'Ì'){
                vetor_cont[12] += 1;
            } else if(text.charAt(i) == 'ò' || text.charAt(i) == 'Ò'){
                vetor_cont[13] += 1;
            } else if(text.charAt(i) == 'ù' || text.charAt(i) == 'Ù'){
                vetor_cont[14] += 1;
            } else if(text.charAt(i) == 'ã' || text.charAt(i) == 'Ã'){
                vetor_cont[15] += 1;
            } else if(text.charAt(i) == 'õ' || text.charAt(i) == 'Õ'){
                vetor_cont[16] += 1;
            } else if(text.charAt(i) == 'â' || text.charAt(i) == 'Â'){
                vetor_cont[17] += 1;
            } else if(text.charAt(i) == 'ê' || text.charAt(i) == 'Ê'){
                vetor_cont[18] += 1;
            } else if(text.charAt(i) == 'î' || text.charAt(i) == 'Î'){
                vetor_cont[19] += 1;
            } else if(text.charAt(i) == 'ô' || text.charAt(i) == 'Ô'){
                vetor_cont[20] += 1;
            } else if(text.charAt(i) == 'û' || text.charAt(i) == 'Û'){
                vetor_cont[21] += 1;
            }
        }

        return vetor_cont;
    }
    public static void main(String[] args) {
        String name, url; 
        String text;
        int valid = 0;
        int[] vogais = new int[21];
        do{
            name = sc.nextLine();
            url = sc.nextLine();
            if(name.charAt(0) == 'F' && name.charAt(1) == 'I' && name.charAt(2) == 'M'){ 
                valid = 1;
            }else{
                text = getUrl(url);
                vogais = cont_vogais(text);
                //System.out.println(text);
            }
        }while(valid != 1);

        sc.close();
    }
}
