import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class InteractFile {
    private BufferedReader reader;
    private String stringDialogue;
    private String stringPause;
    
    InteractFile(){
        try {
            reader= new BufferedReader( new FileReader("file.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
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
}