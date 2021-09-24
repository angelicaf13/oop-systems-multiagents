// 
// Decompiled by Procyon v0.5.36
// 

package gui;

import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;

public class Oval extends CenteredGraphicalElement
{
    private Color drawColor;
    private Color fillColor;
    private int width;
    private int height;
    
    public Oval(final int x, final int y, final Color drawColor, final Color fillColor, final int width, final int height) {
        super(x, y);
        this.drawColor = drawColor;
        this.fillColor = fillColor;
        this.width = width;
        this.height = height;
    }
    
    public Oval(final int x, final int y, final Color drawColor, final Color fillColor, final int size) {
        this(x, y, drawColor, fillColor, size, size);
    }
    
    @Override
    public void paint(final Graphics2D g2d) {
        final Stroke currentStroke = g2d.getStroke();
        g2d.setStroke(new BasicStroke(2.0f));
        final Color current = g2d.getColor();
        if (this.fillColor != null) {
            g2d.setColor(this.fillColor);
            g2d.fillOval(this.getX() - this.width / 2, this.getY() - this.height / 2, this.width, this.height);
        }
        g2d.setColor(this.drawColor);
        g2d.drawOval(this.getX() - this.width / 2, this.getY() - this.height / 2, this.width, this.height);
        g2d.setColor(current);
        g2d.setStroke(currentStroke);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.drawColor.toString()) + " circle";
    }
}
