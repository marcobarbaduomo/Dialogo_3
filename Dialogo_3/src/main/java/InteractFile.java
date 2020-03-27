import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InteractFile {
    private BufferedReader reader;
    private String stringDialogue;
    private String stringPause;
    private int lines;
    
    InteractFile(String fileName) throws IOException{
        try {
            reader= new BufferedReader( new FileReader("file.txt"));
            lines= linesCont();
            reader.close();
            reader= new BufferedReader( new FileReader("file.txt"));
            continueReading();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
    
    private int linesCont(){
        String s;
        int i = 1;
        try{
            s= reader.readLine();
            while(s != null){
                s = reader.readLine();
                i++;
            }
        }catch(IOException ex){
            
        }catch(NullPointerException ex){
            System.out.println("line cont in null pointer: " +i);
            return i;
        }
        System.out.println("line contout catch: " +i);
        return i;
    }
    
    public String getDialogue(){ //restituisce la string di dialogo 
        return stringDialogue.substring(4, stringDialogue.length()-1);
    }
    
    public String getActor(){ //restituisce actor1 o actor2 in base al dialogo
        if(stringDialogue.substring(2).equals("t1")){
            return "actor1";
        } else if(stringDialogue.substring(2).equals("t2")){
            return "actor2";
        } return "ciaone";
    }
    
    public int getPause(){ // restituisce l'intero della pausa
        try{
            return Integer.parseInt(stringPause);
        }catch(NumberFormatException ex){
            System.out.println("Pause String not valid");
            return 0;
        }
    }
    
    public synchronized void continueReading(){ //vai avanti a leggere
        try{
        stringDialogue = reader.readLine();
        stringPause = reader.readLine();
        }catch(IOException ex){
            System.out.println("Error while reading file");
        }
    }
}