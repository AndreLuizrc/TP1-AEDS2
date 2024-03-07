import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Questao8 {
    
    public static Scanner sc = new Scanner(System.in);

    public static void PreencArquivo(int n, File arquivo_temp){
        BufferedWriter write = null;
        float num;
        try{
            write = new BufferedWriter(new FileWriter(arquivo_temp));

            for(int i = 0; i < n; i++){
                num = sc.nextFloat();
                write.write(Float.toString(num));
                write.newLine();
            }
        } catch (IOException err){
            err.printStackTrace();
        } finally {
            try {
                if (write != null)
                    write.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void LerArquivo(File arquivo_temp, int n) {

        RandomAccessFile file = null;

        try{
            file = new RandomAccessFile(arquivo_temp, "r");

            file.seek(file.length() - 2);
            for(int i = 0; i < n; i++){
                //file.seek(i);
                System.out.println(file.getFilePointer());
                System.out.println(file.readFloat());
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
            arquivo_temp = File.createTempFile("arquivo_temp",".txt");
            System.out.println(arquivo_temp.getAbsolutePath());
        } catch(IOException err){
            err.printStackTrace();
        }

        PreencArquivo(n,arquivo_temp);
        LerArquivo(arquivo_temp, n);


    }
}
