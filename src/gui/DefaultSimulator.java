// 
// Decompiled by Procyon v0.5.36
// 

package gui;

class DefaultSimulator implements Simulable
{
    @Override
    public void next() {
        this.message("next()");
    }
    
    @Override
    public void restart() {
        this.message("restart()");
    }
    
    private void message(final String functionName) {
        System.out.println("Methode " + functionName + ": pas encore implementee!");
    }
}
