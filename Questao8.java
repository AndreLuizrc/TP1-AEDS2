import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.Scanner;

public class Questao8 {
    
    public static Scanner sc = new Scanner(System.in);

    public static void PreencArquivo(int n, File arquivo_temp){
        sc.useLocale(Locale.US);

        float num;
        RandomAccessFile file = null;
        try{

            //Inicilização do arquivo em modo leitura e escrita
            file = new RandomAccessFile(arquivo_temp, "rw");

            for(int i = 0; i < n; i++){
                num = sc.nextFloat();

                //escrita do float no arquivo
                file.writeFloat(num);

            }
        } catch (IOException err){
            err.printStackTrace();
        } finally {
            try {
                if (file != null)
                    file.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void LerArquivo(File arquivo_temp, int n) {
        
        //long position = 0;
        RandomAccessFile file = null;

        try{

            //Inicialização do arquivo em modo leitura
            file = new RandomAccessFile(arquivo_temp, "r");
            float num;

            while( n > 0){
                //Definição do ponteiro na ultima posição do arquivo
                file.seek(4*(n-1)); 
                num = file.readFloat();
                if(num == (int) num){
                    System.out.println((int) num);
                } else{
                    System.out.println(num);
                }
                n--;
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(file != null){
                    file.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        File arquivo_temp = null;
        int n;
        n = sc.nextInt();

        try{
            //Criação do arquivo temporario
            arquivo_temp = File.createTempFile("arquivo_temp",".txt");
            //System.out.println(arquivo_temp.getAbsolutePath());
        } catch(IOException err){
            err.printStackTrace();
        }

        PreencArquivo(n,arquivo_temp);
        LerArquivo(arquivo_temp, n);


    }
}
