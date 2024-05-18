//Sheer Fiol, Ayman Wehbi
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Reader{

    public static void main (String[] args){
        File file = new File("phase1.csv");
        
        String listIn = "";

        try{
            FileWriter writer = new FileWriter("Output.txt");
            Scanner in = new Scanner(file);
            String[] list = {};
        
            while(in.hasNext()){
                listIn += in.nextLine();
                listIn = listIn.trim();
                listIn += ",";
            }
            
            list = listIn.split(",");
            
            for(int i = 0; i < list.length; i++){
                try{
                    Integer.parseInt(list[i]);
                    writer.write("Intger\n");
                }catch(NumberFormatException e){
                    writer.write("String\n");
                }
            }    
        in.close();
        writer.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}