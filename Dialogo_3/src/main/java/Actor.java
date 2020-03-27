
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actor implements Runnable{
    private String actorName;
    private InteractFile file;
    
    public Actor(String actorName, InteractFile file ){
        this.actorName= actorName;
        this.file= file;
    }

    @Override
    public void run() { //leggere e aspettare
        try {
            for(int i = 0; i < file.getLinesCont(); i++) {
                if(file.getActor().equals(actorName)){
                    System.out.println( actorName +": "+file.getDialogue());
                    file.continueReading();
                    Thread.sleep(file.getPause());
                }else{
                    Thread.sleep(file.getPause());
                }
            }
        }catch (InterruptedException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
