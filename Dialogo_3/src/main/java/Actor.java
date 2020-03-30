
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actor implements Runnable{
    private String actorName;
    private InteractFile file;
    private int linesCont;
    
    public Actor(String actorName, InteractFile file ){
        this.actorName= actorName;
        this.file= file;
        linesCont= file.getLinesCont()/2;
    }

    @Override
    public void run() { //leggere e aspettare
        try {
            for(int i = 0; i < file.getLinesCont(); i++) {
                if(file.getActor().equals(actorName)){
                    System.out.println( actorName +": "+file.getDialogue());
                    int pause= file.getPause()/2;
                    Thread.sleep(pause);
                    file.continueReading();
                    Thread.sleep(pause);
                }else{
                    Thread.sleep(file.getPause());
                }
            }
        }catch (InterruptedException ex) {
            Logger.getLogger(Actor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
