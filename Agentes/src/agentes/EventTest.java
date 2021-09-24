package agentes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angelica Figueroa Muñiz
 */
public class EventTest {
    public static void main(String[] args) throws InterruptedException {
        
        EventManager manager = new EventManager();
        
        for (int i = 2; i <= 10; i += 2) {
            manager.add(new MessageEvent(i, "[PING]"));
        }
        
        for (int i = 3; i <= 9; i += 3) {
            manager.add(new MessageEvent(i, "[PONG]"));
        }
        
        while(!manager.isFinished()){
            manager.next();
            Thread.sleep(1000);
        }
    }
    
}
