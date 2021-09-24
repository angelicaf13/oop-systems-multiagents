// 
// Decompiled by Procyon v0.5.36
// 

package gui;

import java.awt.geom.Rectangle2D;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Text extends CenteredGraphicalElement
{
    private Color color;
    private String text;
    
    public Text(final int x, final int y, final Color c, final String text) {
        super(x, y);
        this.color = c;
        this.text = text;
    }
    
    @Override
    public void paint(final Graphics2D g2d) {
        final Color current = g2d.getColor();
        g2d.setColor(this.color);
        final FontMetrics fm = g2d.getFontMetrics();
        final Rectangle2D r = fm.getStringBounds(this.text, g2d);
        final int x = this.getX() - (int)r.getWidth() / 2;
        final int y = this.getY() - (int)r.getHeight() / 2 + fm.getAscent();
        g2d.drawString(this.text, x, y);
        g2d.setColor(current);
    }
    
    @Override
    public String toString() {
        return "text - " + this.text;
    }
}
