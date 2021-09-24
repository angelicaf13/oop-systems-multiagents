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
public class MessageEvent extends Event{
    
    private String message;
    
    public MessageEvent(int date, String message){
        super(date);
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(this.getDate() + this.message);
    }
    
}
