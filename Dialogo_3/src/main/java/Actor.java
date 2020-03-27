public class Actor implements Runnable{
    private String actorName;
    private InteractFile file;
    
    public Actor(String actorName, InteractFile file ){
        this.actorName= actorName;
        this.file= file;
    }

    @Override
    public void run() {
        
    }
}
