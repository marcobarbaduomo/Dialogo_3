public class Dialogo_3 {
    public static void main(String[] args){
        
        InteractFile file= new InteractFile("file.txt");
                
        Thread actor1 = new Thread(new Actor("actor1", file));
        Thread actor2 = new Thread(new Actor("actor2", file));
                
        actor1.start();
        actor2.start();
    }
}
