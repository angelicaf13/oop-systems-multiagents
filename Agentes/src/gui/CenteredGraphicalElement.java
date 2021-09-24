// 
// Decompiled by Procyon v0.5.36
// 

package gui;

abstract class CenteredGraphicalElement implements GraphicalElement
{
    private int x;
    private int y;
    
    public CenteredGraphicalElement(final int _x, final int _y) {
        this.x = _x;
        this.y = _y;
    }
    
    public void translate(final int tx, final int ty) {
        this.x += tx;
        this.y += ty;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}
